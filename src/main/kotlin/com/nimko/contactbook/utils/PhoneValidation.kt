package com.nimko.contactbook.utils

import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@MustBeDocumented
@Constraint(validatedBy = [PhoneValidator::class])
annotation class PhoneValidation(
    val message: String = "Phone number is not valid!",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class PhoneValidator:ConstraintValidator<PhoneValidation,String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val phoneUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()
        return try{
            val isValid = phoneUtil.isValidNumber(
                phoneUtil.parse(value, Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name))
            isValid
        } catch (e:Exception){
            false
        }
    }
}
