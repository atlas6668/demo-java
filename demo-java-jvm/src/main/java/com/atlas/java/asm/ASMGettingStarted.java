package com.atlas.java.asm;


import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.io.PrintStream;

/**
 * @author sunwenming
 * @date 2019/1/8.
 */
public class ASMGettingStarted {

    /**
     * 创建一个类
     * 创造这个类的无参构造方法
     * @param className
     * @return
     */
    public static ClassWriter createClassWriter(String className){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        // 声明一个类 编译版本1.7 访问标志public 类名 Signature特征签名 父类java.lang.Object 实现的接口
        cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, className, null, Type.getInternalName(Object.class), null);
        // 构造一个无参构造方法 访问标志public 方法名 方法描述 Signature特征签名 抛出的异常
        MethodVisitor noArgsConstructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        // 执行方法栈帧局部变量表的指令ALOAD 执行ALOAD指令 载入第0位变量槽
        noArgsConstructor.visitVarInsn(Opcodes.ALOAD, 0);
        // 执行方法指令INVOKESPECIAL 执行父类初始化方法调用
        noArgsConstructor.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(Object.class), "<init>", "()V", false);
        // 执行返回地址指令RETURN 执行方法返回 无返回值
        noArgsConstructor.visitInsn(Opcodes.RETURN);
        // 方法执行中访问的最大操作数栈深度和局部变量表深度
        noArgsConstructor.visitMaxs(1, 1);
        // 方法执行结束
        noArgsConstructor.visitEnd();
        return cw;
    }

    /**
     * 创建无返回值方法
     * @param className
     * @param methodName
     * @param arg0
     * @return 字节码
     */
    public static byte[] createVoidMethod(String className, String methodName, String arg0) throws Exception {
        ClassWriter cw = createClassWriter(className.replace(".", "/"));
        // 构造一个无参方法 访问标志public 方法名 方法描述 Signature特征签名 抛出的异常
        MethodVisitor voidMethod = cw.visitMethod(Opcodes.ACC_PUBLIC, methodName, "()V", null, null);
        // 执行字段指令GETSTATIC 取得System.out的引用
        voidMethod.visitFieldInsn(Opcodes.GETSTATIC, Type.getInternalName(System.class), "out", "Ljava/io/PrintStream;");
        // 执行LDC指令 arg0 载入操作数栈栈顶
        voidMethod.visitLdcInsn(arg0);
        // println 方法描述
        String printlnDesc = Type.getMethodDescriptor(PrintStream.class.getMethod("println", String.class));
        // 执行方法指令INVOKEVIRTUAL 执行println方法调用
        voidMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(PrintStream.class), "println", printlnDesc, false);
        // 执行返回地址指令RETURN 执行方法返回 无返回值
        voidMethod.visitInsn(Opcodes.RETURN);
        // 方法执行中访问的最大操作数栈深度和局部变量表深度
        voidMethod.visitMaxs(1, 1);
        // 方法执行结束
        voidMethod.visitEnd();
        return cw.toByteArray();
    }

    /**
     * 创建有返回值方法
     * @param className
     * @param methodName
     * @param returnValue
     * @return 字节码
     * @throws Exception
     */
    public static byte[] createReturnMethod(String className, String methodName, int returnValue) throws Exception {
        ClassWriter cw = createClassWriter(className.replace(".", "/"));
        // 构造一个无参方法 访问标志public 方法名 方法描述 Signature特征签名 抛出的异常
        MethodVisitor returnMethod = cw.visitMethod(Opcodes.ACC_PUBLIC, methodName, "()Ljava/lang/Integer;", null, null);
        // 执行指令BIPUSH 载入returnValue到操作数栈顶 具体BIPUSH等指令操作int型数值范围这里不详细介绍
        returnMethod.visitIntInsn(Opcodes.BIPUSH, returnValue);
        // valueOf 方法描述
        String valueOfDesc = Type.getMethodDescriptor(Integer.class.getMethod("valueOf", int.class));
        // 执行方法指令INVOKESTATIC 执行valueOf方法调用
        returnMethod.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(Integer.class), "valueOf", valueOfDesc, false);
        // 执行返回地址指令ARETURN 执行方法返回 返回值对象类型 具体ARETURN等指令返回范围这里不详细介绍
        returnMethod.visitInsn(Opcodes.ARETURN);
        // 方法执行中访问的最大操作数栈深度和局部变量表深度
        returnMethod.visitMaxs(1, 1);
        // 方法执行结束
        returnMethod.visitEnd();
        return cw.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        // 无返回值
        String className0 = "edu.atlas.demo.java.asm.Test0";
        byte[] voidBytes = createVoidMethod(className0, "method0", "Hello world.");
        Class<?> voidClazz = new MyClassLoader().defineClass(className0, voidBytes);
        voidClazz.getMethods()[0].invoke(voidClazz.newInstance());
        // int返回值
        String className1 = "edu.atlas.demo.java.asm.Test1";
        byte[] intBytes = createReturnMethod(className1, "method1", 100);
        Class<?> returnClazz = new MyClassLoader().defineClass(className1, intBytes);
        Object value = returnClazz.getMethods()[0].invoke(returnClazz.newInstance());
        System.out.println(value);
    }

}
