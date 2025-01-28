fun main() {

    val array = arrayOf(2, 4, 7, 1, 2, 4)
    println(array.contentDeepToString())
    println(returnsMap(array))
    println()

    val people = mutableMapOf(1 to "Иван", 2 to "Петр", 3 to "Лида", 4 to "Петр", 5 to "Анна")
    println(people)
    deletesElementsBasedOnValueEnteredFromKeyboard(people)
    println(people)
    println()

    val personHashMap = mapOf<Int, Person>(
        1 to Person("Ivan", 16, "student"),
        2 to Person("Petr", 32, "worker"),
        3 to Person("Tatiana", 22, "engineer")
    )
    println(personHashMap)
}

/*
Напишите функцию, которая получает на вход массив элементов типа К (Generic) и возвращает Map<K, Int>,
где K — значение из массива, а Int — количество вхождений в массив.
Т.е. массив val array = arrayOf(2, 4, 7, 1, 2, 4). Выходные данные: {1=1, 2=2, 4=2, 7=1}.
*/
fun <K> returnsMap(array: Array<K>): Map<K, Int> {
    val map = mutableMapOf<K, Int>()
    val keys = array.toList().sortedBy { it.toString() }
    for (a in keys) if (!map.containsKey(key = a)) map[a] = array.count { it == a }
    return map
}

/*
Дан map val people = mutableMapOf(1 to "Иван", 2 to "Петр",3 to "Лида", 4 to "Петр", 5 to "Анна").
Написать функцию, удаляющую элементы по введенному с клавиатуры значению.
Т.е., если набрали «Петр» коллекция должна стать такого вида {1=Иван, 3=Лида, 5=Анна}
*/
fun deletesElementsBasedOnValueEnteredFromKeyboard(map: MutableMap<Int, String>) {
    println("Введите значение для удаления элемента:")
    val value = readln()
    if (map.containsValue(value)) map.values.removeIf { it == value } else println("Введенного значения $value нет в коллекции")
}

/*
Создать data класс Person, в конструктор он принимает свойства имени, возраста и должности.
В главной функции создать personHashMap и заполнить его несколькими элементами,
где ключом будет целое число – порядковый номер, значением – объект Person.
Вывести полученную коллекцию в консоль.
*/
data class Person(val name: String, val age: Int, val position: String)