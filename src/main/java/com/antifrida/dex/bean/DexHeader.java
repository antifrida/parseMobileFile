package com.antifrida.dex.bean;

import com.antifrida.utils.Reader;
import com.antifrida.utils.TransformUtils;

import java.io.IOException;

import static com.antifrida.utils.Reader.log;

public class DexHeader {

    /*  http://androidxref.com/9.0.0_r3/xref/dalvik/libdex/DexFile.h
    struct DexHeader {
    u1  magic[8];
    u4  checksum;
    u1  signature[kSHA1DigestLen];
    u4  fileSize;
    u4  headerSize;
    u4  endianTag;
    u4  linkSize;
    u4  linkOff;
    u4  mapOff;
    u4  stringIdsSize;
    u4  stringIdsOff;
    u4  typeIdsSize;
    u4  typeIdsOff;
    u4  protoIdsSize;
    u4  protoIdsOff;
    u4  fieldIdsSize;
    u4  fieldIdsOff;
    u4  methodIdsSize;
    u4  methodIdsOff;
    u4  classDefsSize;
    u4  classDefsOff;
    u4  dataSize;
    u4  dataOff;
    }
    */

    private Reader reader;
    public String magic;
    public long checkSum;
    public String signature;
    public int file_size;
    public int header_size;
    public int endian_tag;
    public int link_size;
    public int link_off;
    public int map_off;
    public int string_ids__size;
    public int string_ids_off;
    public int type_ids__size;
    public int type_ids_off;
    public int proto_ids__size;
    public int proto_ids_off;
    public int field_ids__size;
    public int field_ids_off;
    public int method_ids_size;
    public int method_ids_off;
    public int class_defs_size;
    public int class_defs_off;
    public int data_size;
    public int data_off;

    public DexHeader(Reader reader) {
        this.reader = reader;
    }

    public void parse() {
        try {
            // u1  magic[8]; 魔数
            this.magic = TransformUtils.bytes2String(reader.readOrigin(8));
            log("magic: %s", magic);

            // u4  checksum; alder32 校验值
            this.checkSum = reader.readUnsignedInt();
            log("checkSum: 0x%x", checkSum);

            // u1  signature[kSHA1DigestLen]; kSHA1DigestLen => 20; sha1 校验值
            this.signature = TransformUtils.byte2HexStr(reader.readOrigin(20));
            log("signature: %s", signature);

            // u4  fileSize; DEX 文件大小
            this.file_size = reader.readInt();
            log("file_size: %d", file_size);

            // u4  headerSize; DEX 文件头大小
            this.header_size = reader.readInt();
            log("header_size: %d", header_size);

            // u4  endianTag; 字节序 （大端小端）
            this.endian_tag = reader.readInt();
            log("endian_tag: 0x%x", endian_tag);

            // u4  linkSize; 链接段大小
            this.link_size = reader.readInt();
            log("link_size: %d", link_size);

            // u4  linkOff; 链接段的偏移量
            this.link_off = reader.readInt();
            log("link_off: 0x%x", link_off);

            // u4  mapOff; DexMapList 偏移量
            this.map_off = reader.readInt();
            log("map_off: 0x%x", map_off);

            // u4  stringIdsSize; DexStringId 个数
            this.string_ids__size = reader.readInt();
            log("string_ids__size: %d", string_ids__size);

            // u4  stringIdsOff; DexStringId 偏移量
            this.string_ids_off = reader.readInt();
            log("string_ids_off: 0x%x", string_ids_off);

            // u4  typeIdsSize; DexTypeId 个数
            this.type_ids__size = reader.readInt();
            log("type_ids__size: %d", type_ids__size);

            // u4  typeIdsOff; DexTypeId 偏移量
            this.type_ids_off = reader.readInt();
            log("type_ids_off: 0x%x", type_ids_off);

            // u4  protoIdsSize; DexProtoId 个数
            this.proto_ids__size = reader.readInt();
            log("proto_ids__size: %d", proto_ids__size);

            // u4  protoIdsOff; DexProtoId 偏移量
            this.proto_ids_off = reader.readInt();
            log("proto_ids_off: 0x%x", proto_ids_off);

            // u4  fieldIdsSize; DexFieldId 个数
            this.field_ids__size = reader.readInt();
            log("field_ids__size: %d", field_ids__size);

            // u4  fieldIdsOff; DexFieldId 偏移量
            this.field_ids_off = reader.readInt();
            log("field_ids_off: 0x%x", field_ids_off);

            // u4  methodIdsSize; DexMethodId 个数
            this.method_ids_size = reader.readInt();
            log("method_ids_size: %d", method_ids_size);

            // u4  methodIdsOff; DexMethodId 偏移量
            this.method_ids_off = reader.readInt();
            log("method_ids_off: 0x%x", method_ids_off);

            // u4  classDefsSize; DexCLassDef 个数
            this.class_defs_size = reader.readInt();
            log("class_defs_size: %d", class_defs_size);

            // u4  classDefsOff; DexClassDef 偏移量
            this.class_defs_off = reader.readInt();
            log("class_defs_off: 0x%x", class_defs_off);

            // u4  dataSize; 数据段大小
            this.data_size = reader.readInt();
            log("data_size: %d", data_size);

            // u4  dataOff; // 数据段偏移量
            this.data_off = reader.readInt();
            log("data_off: 0x%x", data_off);

        } catch (IOException e) {
            e.printStackTrace();
            log("parse dex header error!");
        }
    }
}

