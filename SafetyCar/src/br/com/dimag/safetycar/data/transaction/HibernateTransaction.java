
package br.com.dimag.safetycar.data.transaction;

/**
 * Annotation to mark the methods as transactional
 * 
 */
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HibernateTransaction {
}
