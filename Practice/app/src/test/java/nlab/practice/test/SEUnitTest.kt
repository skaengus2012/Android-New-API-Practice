package nlab.practice.test

import nlab.practice.db.model.erp.MemberVO
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * 코틀린 기본 문법에 대한 테스트 코드 기술.
 * (Standard Edition.)
 *
 * 참고 URL ->
 * https://github.com/skaengus2012/Android-Practice-2018/issues/1
 *
 * @author ndh1002
 */
class SEUnitTest {

    /**
     * "Hello World" 는 한번 찍고 시작.
     */
    @Test
    fun printHelloWorld() {
        println("Hello World!")
    }

    /**
     * 데이터 타입에 대한 테스트.
     *
     * var 는 가변변수, val 상수를 의미.
     */
    @Test
    fun testDataTypeDefinition() {
        var temp : Int = 5
        var doubleData : Double = 10.6
        val floatData = 5.5F
        val booleanData = true

        println(temp)
        println(doubleData)
        println(floatData)
        println(booleanData)
    }

    /**
     * 반복문 Simple Test
     *
     * for-loop 스타일만 테스트 표기에 정의 -> while 과 do-while 은 기존 JAVA 와 동일.
     *
     */
    @Test
    fun testSimpleRepeat() {
        val numbers = listOf(1, 2, 3, 4)

        // simple for-loop
        for (number in numbers) {
            print("$number ")
        }
        println()

        // for-loop using until
        for (index in 0 until numbers.size) {
            print("${numbers[index]} ")
        }
        println()

        // for-loop with Step.
        for (number in 0..10 step 2) {
            print("$number ")
        }
        println()
    }

    /**
     * When 구문에 대한 테스트 정의.
     */
    @Test
    fun testWhen() {
        runByWhen(1)
        runByWhen(2)
        runByWhen(4)
        runByWhen("String Value 입니다.")
        runByWhen(3.5f)
    }

    /**
     * [data] 의 값 또는 타입에 따라 다른 일을 구성하는 When 절에 대한 테스트.
     * When 절은 Java 의 Switch 와 비슷.
     *
     * @param data
     */
    private fun runByWhen (data : Any) {
        when(data) {
            1 -> println("일 입니다.")
            2, 4 -> {
                println("이 테스트 입니다.")
                println("2 또는 4 입니다.")
            }

            is String -> println("스트링")

            else -> {
                println("디폴트 값")
            }
        }
    }

    /**
     * 범위 표현에 대한 테스트.
     */
    @Test
    fun testSimpleRange() {
        val rangeZeroToFive = 0..5

        // 범위 포함되는 경우.
        assert(rangeZeroToFive.contains(3))

        // 범위 포함되지 않는 경우.
        assert(rangeZeroToFive.contains(8))
    }

    /**
     * 함수 표기 및 실행에 대한 테스트.
     */
    @Test
    fun testSimpleFunction() {
        val number1 = 5
        val number2 = 10

        val sumResult = sum(number1, number2)
        println("합 결과 $sumResult")

        val sumResult2 = sumExpressSummary(sumResult, number1)
        println("합 결과 2 $sumResult2")
    }

    /**
     * [a] 와 [b] 를 덧셈한 결과를 출력.
     *
     * 기본 함수표현식.
     *
     * @param a
     * @param b
     */
    private fun sum(a : Int, b : Int) : Int {
        return a + b
    }

    /**
     * [a] 와 [b] 를 덧셈한 결과를 출력.
     *
     * 연산 하나에 대한 함수는 = 을 사용하여 표기가 가능함.
     *
     * @param a
     * @param b
     */
    private fun sumExpressSummary(a : Int, b : Int) : Int = a + b

    /**
     * Null 에 대한 명시 및 안전한 사용법 (using safe) 테스트.
     */
    @Test
    fun testNullHandling() {
        // 변수명 뒤에 ? 는 해당 값에 데이터가 있을수도 있고 없을 수도 있음을 의미.
        var optionalValue : Int? = null

        // Null Check 는 JAVA 와 동일.
        if (optionalValue == null) println("현재는 데이터가 존재하지 않는 상태.")

        // Safe 하게 사용하려면,
        // ?. 라는 키워드로 안전하게 사용 가능.
        optionalValue = 7
        optionalValue?.let { println("값이 존재하는 상태 -> [$it]") }

        // ?: 라는 키워드로 값이 존재하지 않을 때의 기능을 사용할 수 있음.
        optionalValue = null
        println("값이 존재하지 않을 때 디폴트 값을 주는 처리 -> [${optionalValue ?: -1}]")

        // !! : Optional 상태에서 NonNull 형태로 변환.
        optionalValue = 8
        val value : Int = optionalValue!!
        println("데이터 추출 처리 -> $value")
    }

    /**
     * 코틀린에서 제공하는 내장 함수 테스트.
     *
     * 내장 함수들은 Kotlin 에서 제공하는 모든 객체에서 사용할 수 있음.
     * 기본적인 설명
     */
    @Test
    fun testKotlinBasicFunction() {

        // apply : 함수를 호출하는 객체를 이어지는 블록으로 전달, 블록안에서는 호출한 객체를 반환.
        val numbers : List<Int>? = ArrayList<Int>().apply {
            // this 키워드를 이용하여, 호출한 객체에 접근이 가능.
            this.add(1)
            this.add(2)

            // 해당 함수를 이용하여, 객체 생성 시 초기화 블럭으로 사용이 가능.
        }

        // let : 함수를 호출하는 객체를 이어지는 블록으로 전달, 블록 내부에서는 처리된 결과를 반환.
        numbers?.let {
            // it 키워드를 이용하여, 함수를 호출한 객체에 접근 가능.
            // 해당 예제에서는 Unit (자바의 Void) 타입을 리턴
            //              -> 블록 내에서는 return 키워드를 붙이지 않음. 마지막 줄이 리턴 값.
            println("[Test, apply & let] 블록에서 세팅한 값을 let 블록에서 사용 $it")
        }

        // run : 인자 없이, 블록 내부의 값을 반환.

        // 사용방식 1 : 익명함수처럼 사용.
        kotlin.run { println("[Test, run] 일반 익명함수 실행") }
        // 사용방식 2 : 특정 객체의 호출에 의한 익명함수 실행.
        numbers?.run { println("[Test, run] numbers 가 존재한다면 실행") }


        // with : with 는 인자를 받는 함수로 해당 인자는 내부 블록으로 전달됨. 블록 내부에서는 처리된 결과를 반환.
        with(numbers) {
            // this 키워드로 접근 가능. -> 해당 예제에서는 Unit 타입을 리턴.
            this?.let { println("[Test, with] $it") }
        }

        // takeIf : 함수를 호출하는 객체를 이어지는 블록으로 전달
        // 블록 내부에서는 해당 객체에 대한 컨디션을 판단 후 객체에 대한 옵셔널 값을 출력.
        numbers?.takeIf { numbers.size == 2 }?.let { println(it) }
    }

    @Test
    fun testDownToRange() {
        for (index in 20 downTo 0 step 2) {
            println(index)
        }
    }

    @Test
    fun testIteratorTuple() {
        val list = listOf("A", "B", "C", "D")

        // original
        println("Original")
        for ((index, value) in list.withIndex()) {
            println("Index : $index, item: $value")
        }
        println()
        println()

        // functional
        println("Functional")
        list.forEachIndexed { index, str -> println("Index : $index, item: $str") }
    }

    @Test
    fun testMapIteratorTuple() {
        val map = mapOf(
                1 to "A",
                2 to "B",
                3 to "C")

        // original
        println("Original")
        for ((key, value) in map.entries) {
            println("Index : $key, item: $value")
        }
        println()
        println()

        // functional
        println("Functional")
        map.forEach { println("Index : ${it.key}, item: ${it.value}") }
    }

    @Test
    fun testStringRange() {
        val range = "Android" .. "Oreo"

        println("Pie is contains : ${"Pie" in range}")
        println("ButterKnife is contains : ${"ButterKnife" in range}")
    }

    @Test
    fun testCharIterator() {
        for (c in "ABC") {
            println(c)
        }
    }

    @Test
    fun testCompareValueBy() {
        val doohyun = MemberVO(1, "Doohyun", "KR19179")
        val steeve = MemberVO(1, "Steeve", "KR19179")

        assertTrue(compareValuesBy(doohyun, steeve, MemberVO::employeeId, MemberVO::memberSn) == 0)
        assertFalse(compareValuesBy(doohyun, steeve, MemberVO::employeeId, MemberVO::name) == 0)
    }
}
