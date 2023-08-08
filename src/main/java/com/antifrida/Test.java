package com.antifrida;

public class Test {

        public static void main(String[] args) {
            int decimalValue = -1; // 原码表示
            // int bits = 8; // 使用8位表示，可根据需求调整
            //
            // String binaryString = decimalToBinary(decimalValue, bits);
            // String complement = calculateTwosComplement(binaryString);
            //
            // System.out.println("Original Decimal: " + decimalValue);
            // System.out.println("Binary Representation: " + binaryString);
            // System.out.println("Twos Complement: " + complement);
            // for (int i = 0; i < 8; i++)
            // {
            //     // 0x80000000 是一个首位为1，其余位数为0的整数
            //     int t = (decimalValue & 0x80 >>> i) >>> (7 - i);
            //     System.out.println(t);
            // }

            int result = complement(decimalValue);
            System.out.println(result);

        }

        public static int complement(int num){
            StringBuilder binaryStringBuilder = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                int t = (num & (0x80 >>> i)) >>> (7 - i);
                binaryStringBuilder.append(t);
            }

            return Integer.parseInt(binaryStringBuilder.toString(), 2);
        }

        // 将十进制转换为二进制字符串
        public static String decimalToBinary(int decimalValue, int bits) {
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(Math.abs(decimalValue)));
            while (binary.length() < bits) {
                binary.insert(0, "0");
            }
            if (decimalValue < 0) {
                binary.setCharAt(0,'1');
            }
            return binary.toString();
        }

        // 计算补码
        public static String calculateTwosComplement(String binaryString) {
            StringBuilder complement = new StringBuilder(8);
            complement.insert(0,binaryString.charAt(0));
            boolean flag = binaryString.charAt(0) == '1' ? true : false;
            for (int i = 1; i < binaryString.length(); i++) {
                char bit = binaryString.charAt(i);
                // 如果是负数
                if(flag) {
                    if (bit == '0') {
                        complement.insert(i, '1');
                    } else {
                        complement.insert(i, '0');
                    }
                }
                // 如果是正数 => 原码、反码、补码一样
                else{
                    complement.insert(i, binaryString.charAt(i));
                }
            }
            if(flag){
                // complement.setCharAt(7,);11000011
            }
            return complement.toString();
        }
}

