package com.antifrida.dex.bean;

public class DexProtoId {

   // struct DexProtoId {         /× 表示方法声明信息，它包含以下三个变量 */
   //     u4  shortyIdx;          /* index into stringIds for shorty descriptor （指向 stringIds ，表示方法声明的字符串）*/
   //     u4  returnTypeIdx;      /* index into typeIds list for return type （指向 typeIds 表示方法的返回类型）*/
   //     u4  parametersOff;      /* file offset to type_list for parameter types （方法参数列表的偏移）*/
   // };

    public int shorty_idx;      // 指向 string_ids
    public int return_type_idx; // 指向 types_ids
    public int parameters_off;


    public DexProtoId(int shorty_idx, int return_type_idx, int parameters_off) {
        this.shorty_idx = shorty_idx;
        this.return_type_idx = return_type_idx;
        this.parameters_off = parameters_off;
    }

    @Override
    public String toString() {
        return "DexProtoId{" +
                "shorty_idx=" + shorty_idx +
                ", return_type_idx=" + return_type_idx +
                ", parameters_off=" + parameters_off +
                '}';
    }
}
