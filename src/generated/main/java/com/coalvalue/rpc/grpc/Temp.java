// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test.proto

package com.coalvalue.rpc.grpc;

/**
 * Protobuf type {@code grpc.Temp}
 */
public  final class Temp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.Temp)
    TempOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Temp.newBuilder() to construct.
  private Temp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Temp() {
    newTemp_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Temp(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            newTemp_ = input.readUInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.coalvalue.rpc.grpc.HelloWorldServiceProto.internal_static_grpc_Temp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.coalvalue.rpc.grpc.HelloWorldServiceProto.internal_static_grpc_Temp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.coalvalue.rpc.grpc.Temp.class, com.coalvalue.rpc.grpc.Temp.Builder.class);
  }

  public static final int NEWTEMP_FIELD_NUMBER = 1;
  private int newTemp_;
  /**
   * <pre>
   * set the temp 
   * </pre>
   *
   * <code>uint32 newTemp = 1;</code>
   */
  public int getNewTemp() {
    return newTemp_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (newTemp_ != 0) {
      output.writeUInt32(1, newTemp_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (newTemp_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, newTemp_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.coalvalue.rpc.grpc.Temp)) {
      return super.equals(obj);
    }
    com.coalvalue.rpc.grpc.Temp other = (com.coalvalue.rpc.grpc.Temp) obj;

    boolean result = true;
    result = result && (getNewTemp()
        == other.getNewTemp());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NEWTEMP_FIELD_NUMBER;
    hash = (53 * hash) + getNewTemp();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coalvalue.rpc.grpc.Temp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.coalvalue.rpc.grpc.Temp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coalvalue.rpc.grpc.Temp parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.coalvalue.rpc.grpc.Temp prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.Temp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.Temp)
      com.coalvalue.rpc.grpc.TempOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.coalvalue.rpc.grpc.HelloWorldServiceProto.internal_static_grpc_Temp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.coalvalue.rpc.grpc.HelloWorldServiceProto.internal_static_grpc_Temp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.coalvalue.rpc.grpc.Temp.class, com.coalvalue.rpc.grpc.Temp.Builder.class);
    }

    // Construct using com.coalvalue.rpc.grpc.Temp.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      newTemp_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.coalvalue.rpc.grpc.HelloWorldServiceProto.internal_static_grpc_Temp_descriptor;
    }

    public com.coalvalue.rpc.grpc.Temp getDefaultInstanceForType() {
      return com.coalvalue.rpc.grpc.Temp.getDefaultInstance();
    }

    public com.coalvalue.rpc.grpc.Temp build() {
      com.coalvalue.rpc.grpc.Temp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.coalvalue.rpc.grpc.Temp buildPartial() {
      com.coalvalue.rpc.grpc.Temp result = new com.coalvalue.rpc.grpc.Temp(this);
      result.newTemp_ = newTemp_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.coalvalue.rpc.grpc.Temp) {
        return mergeFrom((com.coalvalue.rpc.grpc.Temp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.coalvalue.rpc.grpc.Temp other) {
      if (other == com.coalvalue.rpc.grpc.Temp.getDefaultInstance()) return this;
      if (other.getNewTemp() != 0) {
        setNewTemp(other.getNewTemp());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.coalvalue.rpc.grpc.Temp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.coalvalue.rpc.grpc.Temp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int newTemp_ ;
    /**
     * <pre>
     * set the temp 
     * </pre>
     *
     * <code>uint32 newTemp = 1;</code>
     */
    public int getNewTemp() {
      return newTemp_;
    }
    /**
     * <pre>
     * set the temp 
     * </pre>
     *
     * <code>uint32 newTemp = 1;</code>
     */
    public Builder setNewTemp(int value) {
      
      newTemp_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * set the temp 
     * </pre>
     *
     * <code>uint32 newTemp = 1;</code>
     */
    public Builder clearNewTemp() {
      
      newTemp_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.Temp)
  }

  // @@protoc_insertion_point(class_scope:grpc.Temp)
  private static final com.coalvalue.rpc.grpc.Temp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.coalvalue.rpc.grpc.Temp();
  }

  public static com.coalvalue.rpc.grpc.Temp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Temp>
      PARSER = new com.google.protobuf.AbstractParser<Temp>() {
    public Temp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Temp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Temp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Temp> getParserForType() {
    return PARSER;
  }

  public com.coalvalue.rpc.grpc.Temp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

