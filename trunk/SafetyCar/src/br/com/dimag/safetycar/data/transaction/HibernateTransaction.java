
package br.com.dimag.safetycar.data.transaction;

/**
 * Annotation to mark the methods as transactional
 * 
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HibernateTransaction {
}
