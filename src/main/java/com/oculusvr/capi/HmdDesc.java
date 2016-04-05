package com.oculusvr.capi;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.oculusvr.capi.OvrLibrary.*;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HmdDesc extends Structure implements Structure.ByValue {
  public int Type;                                  ///< The type of HMD.
  public byte[] padding1 = new byte[4];             ///< \internal struct paddding.
  public byte[] ProductName = new byte[64];         ///< UTF8-encoded product identification string (e.g. "Oculus Rift DK1").
  public byte[] Manufacturer = new byte[64];        ///< UTF8-encoded HMD manufacturer identification string.
  public short VendorId;                            ///< HID (USB) vendor identifier of the device.
  public short ProductId;                           ///< HID (USB) product identifier of the device.
  public byte[] SerialNumber = new byte[24];        ///< HMD serial number.
  public short FirmwareMajor;                       ///< HMD firmware major version.
  public short FirmwareMinor;                       ///< HMD firmware minor version.
  public int AvailableHmdCaps;                      ///< Capability bits described by ovrHmdCaps which the HMD currently supports.
  public int DefaultHmdCaps;                        ///< Capability bits described by ovrHmdCaps which are default for the current Hmd.
  public int AvailableTrackingCaps;                 ///< Capability bits described by ovrTrackingCaps which the system currently supports.
  public int DefaultTrackingCaps;                   ///< Capability bits described by ovrTrackingCaps which are default for the current system.
  public FovPort[] DefaultEyeFov = new FovPort[ovrEyeType.ovrEye_Count];  ///< Defines the recommended FOVs for the HMD.
  public FovPort[] MaxEyeFov = new FovPort[ovrEyeType.ovrEye_Count];      ///< Defines the maximum FOVs for the HMD.
  public OvrSizei Resolution;                       ///< Resolution of the full HMD screen (both eyes) in pixels.
  public float DisplayRefreshRate;                  ///< Nominal refresh rate of the display in cycles per second at the time of HMD creation.
  public byte[] padding2 = new byte[4];             ///< \internal struct paddding.

  public HmdDesc() {
    super();
  }

  public HmdDesc(Pointer peer) {
    super(peer);
  }

  @Override
  protected List<?> getFieldOrder() {
    return Arrays.asList("Type", "padding1", "ProductName", "Manufacturer", "VendorId", "ProductId", "SerialNumber",
        "FirmwareMajor", "FirmwareMinor", "AvailableHmdCaps", "DefaultHmdCaps",
        "AvailableTrackingCaps", "DefaultTrackingCaps", "DefaultEyeFov", "MaxEyeFov", "Resolution",
        "DisplayRefreshRate", "padding2");
  }
  
  /**
   * Product identification string (e.g. "Oculus Rift DK1").
   * @return Product identification string (e.g. "Oculus Rift DK1").
   */
  public String getProductName() {
    try {
      return new String(ProductName, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(HmdDesc.class.getName()).log(Level.SEVERE, null, ex);
      
      return null;
    }
  }

  /**
   * HMD manufacturer identification string.  
   * @return HMD manufacturer identification string.  
   */

  public String getManufacturer() {
    try {
      return new String(Manufacturer, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(HmdDesc.class.getName()).log(Level.SEVERE, null, ex);
      
      return null;
    }
  }

}
