package com.oceanngrsmith.ocheejeh.hublocker.models;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Helper class for pojo(i.e. models) tests
 */

public class ModelTestUtil {
    private static final Validator ACCESSOR_VALIDATOR = ValidatorBuilder.create()
            .with(new GetterTester())
            .with(new SetterTester())
            .build();

    public static void validateAccessors(final Class<?> clazz) {
        ACCESSOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }
}
