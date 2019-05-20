package com.shilei.hello.instrument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class CheatTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        // 替换一个类的实现
        if (className.equalsIgnoreCase("com/shilei/hello/service/impl/StudentServiceImpl")) {
            return getBytesFromFile();
        }
        return null;
    }

    private byte[] getBytesFromFile() {
        String fileName = "/Users/qianshilei/Code/github/HelloSpringBoot/tmp/StudentServiceImpl.class";
        File file = new File(fileName);

        try (InputStream is = new FileInputStream(file)) {
            long length = file.length();
            byte[] bytes = new byte[(int) length];

            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
            is.close();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
