// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test.proto

package com.coalvalue.rpc.grpc;

public interface RectangleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.Rectangle)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.grpc.Point lo = 1;</code>
   */
  boolean hasLo();
  /**
   * <code>.grpc.Point lo = 1;</code>
   */
  com.coalvalue.rpc.grpc.Point getLo();
  /**
   * <code>.grpc.Point lo = 1;</code>
   */
  com.coalvalue.rpc.grpc.PointOrBuilder getLoOrBuilder();

  /**
   * <code>.grpc.Point hi = 2;</code>
   */
  boolean hasHi();
  /**
   * <code>.grpc.Point hi = 2;</code>
   */
  com.coalvalue.rpc.grpc.Point getHi();
  /**
   * <code>.grpc.Point hi = 2;</code>
   */
  com.coalvalue.rpc.grpc.PointOrBuilder getHiOrBuilder();
}
