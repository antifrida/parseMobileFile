package com.antifrida.dex.bean;

public class DexFieldId {

   // struct DexFieldId {
   //     u2  classIdx;           /* index into typeIds list for defining class （field 所在的类）*/
   //     u2  typeIdx;            /* index into typeIds for field type （field 类型）*/
   //     u4  nameIdx;            /* index into stringIds for field name （field 名称）*/
   // };

    public int class_idx; // 指向 type_ids
    public int type_idx; // 指向 type_ids
    public int name_idx; // 指向 string_ids

    public DexFieldId(int class_idx, int type_idx, int name_idx) {
        this.class_idx = class_idx;
        this.type_idx = type_idx;
        this.name_idx = name_idx;
    }

    @Override
    public String toString() {
        return "DexFieldId{" +
                "class_idx=" + class_idx +
                ", type_idx=" + type_idx +
                ", name_idx=" + name_idx +
                '}';
    }
}
