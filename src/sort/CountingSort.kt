package sort
//计数排序
fun countingSort(a: IntArray): IntArray {
    var temp = IntArray(100);
    for (item in a) {
        temp[item] += 1
    }
    for (i in 1..99) {
        temp[i] += temp[i - 1]
    }
    var t = IntArray(a.size)
    for (j in a.size - 1 downTo 0) {
        t[temp[a[j]]-1] = a[j]
        temp[a[j]]--
    }
    return t
}

fun main(args: Array<String>) {
    val temp = IntArray(10000);
    for (i in 0..9999) {
        temp[i] = (1..99).shuffled().last();
    }
    val re = countingSort(temp)
    print(re)
    for (item in re.indices) {
        if (item % 100 == 0) {
            println()
        }
        print(re[item].toString() + "\t")
    }
}