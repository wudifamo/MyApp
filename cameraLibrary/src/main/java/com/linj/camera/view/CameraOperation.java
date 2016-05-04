package com.linj.camera.view;

import android.graphics.Bitmap;
import android.hardware.Camera.PictureCallback;

import com.linj.camera.view.CameraContainer.TakePictureListener;
import com.linj.camera.view.CameraView.FlashMode;

/** 
 * @ClassName: CameraOperation 
 * @Description:��������ӿڣ�����ͳһCameraContainer��CameraView�Ĺ���
 * @author LinJ
 * @date 2015-1-26 ����2:41:31 
 *  
 */
public interface CameraOperation {
	/**  
	 *  ��ʼ¼��
	 *  @return  �Ƿ�ɹ���ʼ¼��
	 */
	public boolean startRecord();

	/**  
	 *  ֹͣ¼��
	 *  @return ¼������ͼ
	 */
	public Bitmap stopRecord();
	/**  
	 *   �л�ǰ�úͺ������
	 */
	public void switchCamera();
	/**  
	 *  ��ȡ��ǰ�����ģʽ
	 *  @return   
	 */
	public FlashMode getFlashMode();
	/**  
	 *  ���������ģʽ
	 *  @param flashMode   
	 */
	public void setFlashMode(FlashMode flashMode);
	/**  
	 *  ����
	 *  @param callback ���ջص����� 
	 *  @param listener ���ն�����������  
	 */
	public void takePicture(PictureCallback callback,TakePictureListener listener);
	/**  
	 *  ���������ż���
	 *  @return   
	 */
	public int getMaxZoom();
	/**  
	 *  ���õ�ǰ���ż���
	 *  @param zoom   
	 */
	public void setZoom(int zoom);
	/**  
	 *  ��ȡ��ǰ���ż���
	 *  @return   
	 */
	public int getZoom();
}
