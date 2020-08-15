package retrofit

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.provider.MediaStore
import java.io.FileNotFoundException

object AppDelegates {

    fun decodeSampledBitmapFromUri(
        uri: Uri,
        reqWidth: Int,
        reqHeight: Int,
        context: Context
    ): Bitmap? {
        var bm: Bitmap? = null
        try {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeStream(context.contentResolver.openInputStream(uri), null, options)
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)
            options.inJustDecodeBounds = false
            bm = BitmapFactory.decodeStream(
                context.contentResolver.openInputStream(uri),
                null,
                options
            )
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        return bm
    }

    fun calculateInSampleSize(
        options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int
    ): Int {
        // Raw height and width of image
        val height = options.outHeight
        val width = options.outWidth
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {

            val halfHeight = height / 2
            val halfWidth = width / 2

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }


    fun getRealPathFromURI(context: Context, contentUri: Uri): String? {
        var cursor: Cursor? = null
        try {

            if ("content" == contentUri.scheme) {
                val proj = arrayOf(MediaStore.Images.Media.DATA)
                cursor = context.contentResolver.query(contentUri, proj, null, null, null)
                val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                cursor.moveToFirst()
                return cursor.getString(column_index)
            } else {
                return contentUri.path
            }
        } catch (e: Exception) {
            cursor?.close()
            e.printStackTrace()
        }

        return null
    }

    fun rotateImageBitmap(photoPath: String, bitmap: Bitmap): Bitmap? {
        var rotatedBitmap: Bitmap? = null
        try {
            val ei = ExifInterface(photoPath)
            val orientation = ei.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED
            )
            when (orientation) {

                ExifInterface.ORIENTATION_ROTATE_90 -> rotatedBitmap = rotateImage(bitmap, 90f)

                ExifInterface.ORIENTATION_ROTATE_180 -> rotatedBitmap = rotateImage(bitmap, 180f)

                ExifInterface.ORIENTATION_ROTATE_270 -> rotatedBitmap = rotateImage(bitmap, 270f)

                ExifInterface.ORIENTATION_NORMAL -> return bitmap

                ExifInterface.ORIENTATION_UNDEFINED -> return bitmap


                else -> {
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return rotatedBitmap
    }

    private fun rotateImage(source: Bitmap?, angle: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(source!!, 0, 0, source.width, source.height, matrix, true)
    }

}