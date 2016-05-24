/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oculusvr.capi;

import com.oculusvr.capi.OvrLibrary.ovrHandType;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/**
 *
 * InputState describes the complete controller input state, including Oculus
 * Touch, and XBox gamepad. If multiple inputs are connected and used at the
 * same time, their inputs are combined.
 *
 * @author cramirez
 */
public class InputState extends Structure implements Structure.ByReference {

  // System type when the controller state was last updated.
  public double TimeInSeconds;

  // Values for buttons described by ovrButton.
  public int Buttons;

  // Touch values for buttons and sensors as described by ovrTouch.
  public int Touches;

  // Left and right finger trigger values (ovrHand_Left and ovrHand_Right), in the range 0.0 to 1.0f.
  public float IndexTrigger[] = new float[ovrHandType.ovrHand_Count];

  // Left and right hand trigger values (ovrHand_Left and ovrHand_Right), in the range 0.0 to 1.0f.
  public float HandTrigger[] = new float[ovrHandType.ovrHand_Count];

  // Horizontal and vertical thumbstick axis values (ovrHand_Left and ovrHand_Right), in the range -1.0f to 1.0f.
  public OvrVector2f Thumbstick[] = new OvrVector2f[ovrHandType.ovrHand_Count];

  // The type of the controller this state is for.
  public int ControllerType;

  @Override
  protected List getFieldOrder() {
    return Arrays.asList("TimeInSeconds", "Buttons", "Touches", "IndexTrigger", "HandTrigger", "Thumbstick", "ControllerType");
  }

}
