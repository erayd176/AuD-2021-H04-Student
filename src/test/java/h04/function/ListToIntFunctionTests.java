package h04.function;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static h04.Utils.*;
import static java.lang.reflect.Modifier.isPublic;
import static java.lang.reflect.Modifier.isStatic;
import static org.junit.jupiter.api.Assertions.*;

@DefinitionCheck("checkInterface")
class ListToIntFunctionTest {

    public static Class<?> listToIntFunctionClass;
    public static Method apply;

    @BeforeAll
    public static void checkInterface() {
        listToIntFunctionClass = getClassForName("h04.function.ListToIntFunction");

        // is public
        assertTrue(isPublic(listToIntFunctionClass.getModifiers()));

        // is interface
        assertTrue(listToIntFunctionClass.isInterface(), "ListToIntFunction must be an interface");

        // is generic
        assertEquals(1, listToIntFunctionClass.getTypeParameters().length, "ListToIntFunction must be generic");
        assertEquals("T", listToIntFunctionClass.getTypeParameters()[0].getName(), "Type parameter is not named 'T'");

        // methods
        try {
            apply = listToIntFunctionClass.getDeclaredMethod("apply", List.class);

            assertTrue(isPublic(apply.getModifiers()), "Method apply(List) must be public (implicit or explicit)");
            assertFalse(isStatic(apply.getModifiers()), "Method apply(List) must not be static");
            assertFalse(apply.isDefault(), "Method apply(List) must not be default");
            assertEquals(int.class, apply.getReturnType(), "Method apply(List) does not have correct return type");
            assertEquals("java.util.List<T>", apply.getGenericParameterTypes()[0].getTypeName(),
                    "First parameter of method apply(List) is not correctly parameterized");
            assertEquals(1, apply.getExceptionTypes().length, "Method apply(List) must throw exactly one exception");
            assertEquals(NullPointerException.class, apply.getExceptionTypes()[0], "Method apply(List) must throw NullPointerException");
        } catch (NoSuchMethodException e) {
            fail("Interface ListToIntFunction is missing a required method", e);
        }
    }

    @Test
    public void interfaceDefinitionCorrect() {}
}
