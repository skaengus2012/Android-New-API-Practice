package nlab.practice.dagger.injection

import dagger.Component
import nlab.practice.dagger.model.CoffeeMaker
import javax.inject.Singleton

/**
 * CoffeeMaker 를 주입하는 컴포넌트 정의
 *
 * @author Doohyun
 */
@Singleton  // Singleton Injection 사용을 위해서는 해당 어노테이션이 필요해보임
@Component(modules = [DefaultCoffeeMakerModule::class])
interface CoffeeMakerComponent {

    /**
     * Inject 된 상태의 객체 생성
     */
    fun maker() : CoffeeMaker

    /**
     * [coffeeMaker] 를 받아 주입하는 형태
     */
    fun inject(coffeeMaker: CoffeeMaker)
}