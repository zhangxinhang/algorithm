package search
//base bsearch
fun bsearch(a: IntArray, n: Int, value: Int): Int {
    var low = 0
    var high = n - 1
    var mid = 0
    while (low <= high) {
        mid = low + (high - low).shr(1);
        if (a[mid] > value) {
            high = mid - 1
        } else if (a[mid] < value) {
            low = mid + 1
        } else {
            return mid
        }
    }

    return -1
}

fun main(args: Array<String>) {
    var a = arrayOf(1, 2, 4, 5, 6, 8, 10, 13, 15, 18).toIntArray()
    print(a[bsearch(a, a.size, 1)])
}