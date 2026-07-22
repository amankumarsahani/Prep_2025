class SparseTable {
    constructor(data) {
        this.st = [data.slice()];

        let len = 1;
        const n = data.length;

        while (2 * len <= n + 1) {
            const prev = this.st[this.st.length - 1];
            const cur = [];

            for (let i = 0; i + 2 * len <= n + 1; i++) {
                cur.push(Math.max(prev[i], prev[i + len]));
            }

            this.st.push(cur);
            len <<= 1;
        }
    }

    query(left, right) {
        if (left > right) return 0;

        const len = right - left + 1;
        const lg = Math.floor(Math.log2(len));

        return Math.max(
            this.st[lg][left],
            this.st[lg][right - (1 << lg) + 1]
        );
    }
}

/**
 * @param {string} s
 * @param {number[][]} queries
 * @return {number[]}
 */
var maxActiveSectionsAfterTrade = function (s, queries) {
    const n = s.length;

    let totalOnes = 0;
    for (const ch of s) {
        if (ch === '1') totalOnes++;
    }

    const zeroBlocks = [];
    const blockLeft = [];
    const blockRight = [];

    let i = 0;

    while (i < n) {
        const start = i;

        while (i < n && s[i] === s[start]) {
            i++;
        }

        if (s[start] === '0') {
            zeroBlocks.push(i - start);
            blockLeft.push(start);
            blockRight.push(i - 1);
        }
    }

    const m = zeroBlocks.length;

    if (m < 2) {
        return new Array(queries.length).fill(totalOnes);
    }

    const gain = [];

    for (let k = 0; k < m - 1; k++) {
        gain.push(zeroBlocks[k] + zeroBlocks[k + 1]);
    }

    const sparse = new SparseTable(gain);

    const ans = [];

    for (const [l, r] of queries) {
        const idx = lowerBound(blockRight, l);
        const jdx = upperBound(blockLeft, r) - 1;

        if (idx > m - 1 || jdx < 0 || idx >= jdx) {
            ans.push(totalOnes);
            continue;
        }

        const firstLen =
            blockRight[idx] - Math.max(blockLeft[idx], l) + 1;

        const lastLen =
            Math.min(blockRight[jdx], r) - blockLeft[jdx] + 1;

        if (idx + 1 === jdx) {
            ans.push(totalOnes + firstLen + lastLen);
            continue;
        }

        const val1 = firstLen + zeroBlocks[idx + 1];
        const val2 = zeroBlocks[jdx - 1] + lastLen;
        const val3 = sparse.query(idx + 1, jdx - 2);

        ans.push(totalOnes + Math.max(val1, val2, val3));
    }

    return ans;
};

function lowerBound(arr, target) {
    let left = 0;
    let right = arr.length;

    while (left < right) {
        const mid = left + ((right - left) >> 1);

        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}

function upperBound(arr, target) {
    let left = 0;
    let right = arr.length;

    while (left < right) {
        const mid = left + ((right - left) >> 1);

        if (arr[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}