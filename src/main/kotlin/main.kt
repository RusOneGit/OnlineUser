fun main() {
    val agoSec: Int = 600
    var agoText = "был(а) давно"
    var agoFormMin: String = ""
    var agoFormHour: String = ""


    fun formWordHour(agoSec: Int): String {
        when (agoSec) {
            1, 21 -> agoFormHour = " час назад"
            2, 3, 4, 22, 23, 24 -> agoFormHour = " часа назад"
            in 5..20 -> agoFormHour = " часов назад"
        }
        return agoFormHour
    }

    fun formWordMin(agoSec: Int): String {
        when (agoSec) {

            1, 21, 31, 41, 51 -> agoFormMin = " минуту назад"
            2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> agoFormMin = " минуты назад"
            in 5..20 -> agoFormMin = " минут назад"
            in 25..30, in 35..40, in 45..50, in 55..59 -> agoFormMin = " минут назад"

        }
        return agoFormMin
    }


    fun agoToText(agoSec: Int): String {
        when (agoSec) {
            in 0..60 -> agoText = "была(а) только что"
            in 61..60 * 60 -> agoText = "был(а) " + agoSec / 60 + formWordMin(agoSec / 60)
            in (60 * 60) + 1..24 * (60 * 60) -> agoText =
                "был(а) " + agoSec / (60 * 60) + formWordHour(agoSec / (60 * 60))

            in (24 * 60 * 60) + 1..(24 * 60 * 60) * 2 -> agoText = "был(а) вчера"
            in (24 * 60 * 60) * 2 + 1..(24 * 60 * 60) * 3 -> agoText = "был(а) позавчера"
        }
        return agoText
    }




    println(agoToText(agoSec))

}