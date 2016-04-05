package com.oculusvr.capi;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class TrackingState extends Structure implements Structure.ByValue {
  public PoseStatef HeadPose;
  public int StatusFlags;
  public PoseStatef[] HandPoses = new PoseStatef[2];
  /// Hand status flags described by ovrStatusBits.
  /// Only ovrStatus_OrientationTracked and ovrStatus_PositionTracked are reported.
  public int[] HandStatusFlags= new int[2];
  
  
  /// The pose of the origin captured during calibration.
  /// Like all other poses here, this is expressed in the space set by ovr_RecenterTrackingOrigin,
  /// and so will change every time that is called. This pose can be used to calculate
  /// where the calibrated origin lands in the new recentered space.
  /// If an application never calls ovr_RecenterTrackingOrigin, expect this value to be the identity
  /// pose and as such will point respective origin based on ovrTrackingOrigin requested when
  /// calling ovr_GetTrackingState.
  public Posef CalibratedOrigin;

  public TrackingState() {
    super();
  }

  public TrackingState(Pointer peer) {
    super(peer);
  }

  @Override
  protected List<?> getFieldOrder() {
    return Arrays.asList("HeadPose", "StatusFlags", "HandPoses",
        "HandStatusFlags", "CalibratedOrigin");
  }

}
