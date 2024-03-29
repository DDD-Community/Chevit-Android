package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.Logo: ImageVector
    get() {
        if (_logo != null) {
            return _logo!!
        }
        _logo = Builder(
            name = "Logo", defaultWidth = 102.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 102.0f, viewportHeight = 24.0f,
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF3531FF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(6.743f, 2.071f)
                    lineTo(21.175f, 4.603f)
                    arcTo(1.895f, 1.895f, 54.954f, false, true, 22.713f, 6.797f)
                    lineTo(21.558f, 13.38f)
                    arcTo(1.895f, 1.895f, 54.954f, false, true, 19.364f, 14.919f)
                    lineTo(4.933f, 12.386f)
                    arcTo(1.895f, 1.895f, 54.954f, false, true, 3.394f, 10.193f)
                    lineTo(4.55f, 3.609f)
                    arcTo(1.895f, 1.895f, 54.954f, false, true, 6.743f, 2.071f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF4A47FF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd,
                ) {
                    moveTo(8.245f, 6.078f)
                    curveTo(8.245f, 5.849f, 8.06f, 5.664f, 7.832f, 5.664f)
                    horizontalLineTo(3.395f)
                    curveTo(2.348f, 5.664f, 1.5f, 6.512f, 1.5f, 7.559f)
                    verticalLineTo(20.406f)
                    curveTo(1.5f, 21.452f, 2.348f, 22.301f, 3.395f, 22.301f)
                    horizontalLineTo(22.712f)
                    curveTo(23.759f, 22.301f, 24.607f, 21.452f, 24.607f, 20.406f)
                    verticalLineTo(7.559f)
                    curveTo(24.607f, 6.512f, 23.759f, 5.664f, 22.712f, 5.664f)
                    horizontalLineTo(18.315f)
                    curveTo(18.086f, 5.664f, 17.901f, 5.849f, 17.901f, 6.078f)
                    verticalLineTo(6.078f)
                    curveTo(17.901f, 6.306f, 17.716f, 6.491f, 17.487f, 6.491f)
                    horizontalLineTo(8.659f)
                    curveTo(8.43f, 6.491f, 8.245f, 6.306f, 8.245f, 6.078f)
                    verticalLineTo(6.078f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF3532FE)),
                    strokeLineWidth = 1.36922f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero,
                ) {
                    moveTo(8.328f, 3.408f)
                    lineTo(8.415f, 2.903f)
                    curveTo(8.593f, 1.872f, 9.574f, 1.181f, 10.605f, 1.359f)
                    lineTo(17.899f, 2.62f)
                    curveTo(18.93f, 2.798f, 19.621f, 3.778f, 19.443f, 4.809f)
                    lineTo(19.355f, 5.315f)
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(15.84f, 10.499f)
                    lineTo(12.245f, 14.342f)
                    curveTo(12.064f, 14.535f, 11.759f, 14.543f, 11.569f, 14.358f)
                    lineTo(10.302f, 13.127f)
                    curveTo(10.126f, 12.955f, 9.848f, 12.948f, 9.662f, 13.109f)
                    lineTo(8.715f, 13.931f)
                    curveTo(8.506f, 14.112f, 8.497f, 14.433f, 8.694f, 14.627f)
                    lineTo(11.568f, 17.444f)
                    curveTo(11.759f, 17.631f, 12.065f, 17.624f, 12.247f, 17.429f)
                    lineTo(17.43f, 11.857f)
                    curveTo(17.618f, 11.655f, 17.594f, 11.335f, 17.377f, 11.163f)
                    lineTo(16.48f, 10.452f)
                    curveTo(16.287f, 10.299f, 16.008f, 10.319f, 15.84f, 10.499f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(85.003f, 9.191f)
                    horizontalLineToRelative(3.025f)
                    verticalLineToRelative(10.549f)
                    horizontalLineToRelative(-3.025f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(76.283f, 18.528f)
                    lineTo(80.704f, 5.477f)
                    horizontalLineTo(83.639f)
                    lineTo(79.109f, 19.74f)
                    horizontalLineTo(73.363f)
                    lineTo(69.657f, 8.123f)
                    horizontalLineTo(72.619f)
                    lineTo(76.283f, 18.528f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd,
                ) {
                    moveTo(36.337f, 19.178f)
                    lineTo(36.34f, 19.179f)
                    lineTo(36.344f, 19.181f)
                    curveTo(37.291f, 19.543f, 38.316f, 19.722f, 39.416f, 19.722f)
                    curveTo(40.544f, 19.722f, 41.585f, 19.529f, 42.535f, 19.138f)
                    curveTo(43.5f, 18.746f, 44.323f, 18.17f, 44.997f, 17.411f)
                    lineTo(45.242f, 17.136f)
                    lineTo(43.407f, 15.358f)
                    lineTo(43.14f, 15.645f)
                    curveTo(42.646f, 16.176f, 42.096f, 16.565f, 41.491f, 16.82f)
                    curveTo(40.879f, 17.064f, 40.221f, 17.188f, 39.515f, 17.188f)
                    curveTo(38.78f, 17.188f, 38.101f, 17.064f, 37.475f, 16.818f)
                    curveTo(36.859f, 16.572f, 36.328f, 16.229f, 35.876f, 15.79f)
                    curveTo(35.426f, 15.351f, 35.072f, 14.834f, 34.813f, 14.233f)
                    curveTo(34.57f, 13.622f, 34.446f, 12.958f, 34.446f, 12.238f)
                    curveTo(34.446f, 11.517f, 34.57f, 10.86f, 34.813f, 10.264f)
                    curveTo(35.072f, 9.648f, 35.427f, 9.124f, 35.876f, 8.687f)
                    curveTo(36.328f, 8.248f, 36.859f, 7.905f, 37.475f, 7.658f)
                    curveTo(38.101f, 7.413f, 38.78f, 7.288f, 39.515f, 7.288f)
                    curveTo(40.22f, 7.288f, 40.876f, 7.418f, 41.488f, 7.675f)
                    lineTo(41.491f, 7.676f)
                    lineTo(41.494f, 7.677f)
                    curveTo(42.1f, 7.92f, 42.649f, 8.297f, 43.143f, 8.815f)
                    lineTo(43.41f, 9.096f)
                    lineTo(45.242f, 7.32f)
                    lineTo(44.997f, 7.045f)
                    curveTo(44.322f, 6.286f, 43.499f, 5.716f, 42.533f, 5.338f)
                    curveTo(41.584f, 4.948f, 40.55f, 4.755f, 39.435f, 4.755f)
                    curveTo(38.334f, 4.755f, 37.308f, 4.941f, 36.36f, 5.317f)
                    curveTo(35.429f, 5.679f, 34.611f, 6.202f, 33.913f, 6.886f)
                    curveTo(33.215f, 7.556f, 32.671f, 8.346f, 32.281f, 9.251f)
                    curveTo(31.888f, 10.163f, 31.694f, 11.16f, 31.694f, 12.238f)
                    curveTo(31.694f, 13.316f, 31.888f, 14.314f, 32.281f, 15.226f)
                    curveTo(32.67f, 16.129f, 33.206f, 16.923f, 33.889f, 17.606f)
                    lineTo(33.892f, 17.609f)
                    lineTo(33.895f, 17.612f)
                    curveTo(34.592f, 18.282f, 35.408f, 18.804f, 36.337f, 19.178f)
                    close()
                    moveTo(44.71f, 17.156f)
                    curveTo(44.076f, 17.87f, 43.302f, 18.412f, 42.39f, 18.782f)
                    curveTo(41.491f, 19.152f, 40.5f, 19.337f, 39.416f, 19.337f)
                    curveTo(38.358f, 19.337f, 37.38f, 19.165f, 36.481f, 18.822f)
                    curveTo(35.595f, 18.465f, 34.822f, 17.969f, 34.161f, 17.334f)
                    curveTo(33.513f, 16.687f, 33.004f, 15.933f, 32.634f, 15.074f)
                    curveTo(32.264f, 14.215f, 32.079f, 13.269f, 32.079f, 12.238f)
                    curveTo(32.079f, 11.207f, 32.264f, 10.262f, 32.634f, 9.403f)
                    curveTo(32.822f, 8.966f, 33.047f, 8.559f, 33.31f, 8.18f)
                    curveTo(33.048f, 8.559f, 32.822f, 8.966f, 32.634f, 9.402f)
                    curveTo(32.264f, 10.262f, 32.079f, 11.207f, 32.079f, 12.238f)
                    curveTo(32.079f, 13.269f, 32.264f, 14.214f, 32.634f, 15.073f)
                    curveTo(33.004f, 15.933f, 33.513f, 16.686f, 34.161f, 17.334f)
                    curveTo(34.822f, 17.969f, 35.595f, 18.464f, 36.481f, 18.821f)
                    curveTo(37.38f, 19.165f, 38.358f, 19.337f, 39.416f, 19.337f)
                    curveTo(40.5f, 19.337f, 41.491f, 19.152f, 42.39f, 18.781f)
                    curveTo(43.302f, 18.412f, 44.076f, 17.87f, 44.71f, 17.156f)
                    lineTo(44.71f, 17.156f)
                    close()
                    moveTo(44.71f, 7.301f)
                    curveTo(44.71f, 7.301f, 44.71f, 7.301f, 44.71f, 7.301f)
                    lineTo(43.421f, 8.55f)
                    curveTo(43.397f, 8.525f, 43.373f, 8.5f, 43.349f, 8.476f)
                    curveTo(42.839f, 7.958f, 42.268f, 7.573f, 41.637f, 7.32f)
                    curveTo(40.975f, 7.043f, 40.268f, 6.904f, 39.515f, 6.904f)
                    curveTo(38.735f, 6.904f, 38.008f, 7.036f, 37.333f, 7.301f)
                    curveTo(36.673f, 7.565f, 36.097f, 7.935f, 35.608f, 8.411f)
                    curveTo(35.394f, 8.619f, 35.201f, 8.845f, 35.027f, 9.089f)
                    curveTo(35.201f, 8.845f, 35.395f, 8.619f, 35.609f, 8.411f)
                    curveTo(36.098f, 7.935f, 36.673f, 7.565f, 37.334f, 7.3f)
                    curveTo(38.008f, 7.036f, 38.735f, 6.904f, 39.515f, 6.904f)
                    curveTo(40.269f, 6.904f, 40.976f, 7.043f, 41.637f, 7.32f)
                    curveTo(42.298f, 7.585f, 42.893f, 7.994f, 43.421f, 8.55f)
                    lineTo(44.71f, 7.301f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd,
                ) {
                    moveTo(49.603f, 12.198f)
                    curveTo(49.375f, 12.645f, 49.25f, 13.22f, 49.25f, 13.943f)
                    verticalLineTo(19.741f)
                    horizontalLineTo(46.578f)
                    verticalLineTo(4.259f)
                    horizontalLineTo(49.25f)
                    verticalLineTo(9.403f)
                    curveTo(49.447f, 9.248f, 49.662f, 9.109f, 49.893f, 8.984f)
                    curveTo(50.672f, 8.566f, 51.57f, 8.363f, 52.574f, 8.363f)
                    curveTo(53.482f, 8.363f, 54.297f, 8.538f, 55.008f, 8.9f)
                    curveTo(55.741f, 9.267f, 56.312f, 9.826f, 56.718f, 10.566f)
                    curveTo(57.128f, 11.313f, 57.321f, 12.234f, 57.321f, 13.309f)
                    verticalLineTo(19.741f)
                    horizontalLineTo(54.648f)
                    verticalLineTo(13.527f)
                    curveTo(54.648f, 12.567f, 54.412f, 11.913f, 54.004f, 11.495f)
                    lineTo(54.0f, 11.491f)
                    curveTo(53.602f, 11.071f, 53.02f, 10.838f, 52.197f, 10.838f)
                    curveTo(51.574f, 10.838f, 51.049f, 10.96f, 50.611f, 11.19f)
                    curveTo(50.18f, 11.417f, 49.845f, 11.75f, 49.603f, 12.198f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd,
                ) {
                    moveTo(59.166f, 16.937f)
                    curveTo(59.678f, 17.805f, 60.39f, 18.488f, 61.295f, 18.983f)
                    lineTo(61.298f, 18.984f)
                    curveTo(62.221f, 19.481f, 63.277f, 19.724f, 64.454f, 19.724f)
                    curveTo(65.369f, 19.724f, 66.207f, 19.572f, 66.96f, 19.259f)
                    curveTo(67.727f, 18.946f, 68.373f, 18.488f, 68.89f, 17.885f)
                    lineTo(69.104f, 17.635f)
                    lineTo(67.556f, 15.823f)
                    lineTo(67.263f, 16.147f)
                    curveTo(66.917f, 16.528f, 66.515f, 16.812f, 66.053f, 17.001f)
                    lineTo(66.05f, 17.002f)
                    curveTo(65.601f, 17.191f, 65.091f, 17.29f, 64.514f, 17.29f)
                    curveTo(63.813f, 17.29f, 63.208f, 17.149f, 62.689f, 16.877f)
                    curveTo(62.169f, 16.605f, 61.766f, 16.231f, 61.474f, 15.753f)
                    curveTo(61.338f, 15.514f, 61.234f, 15.258f, 61.163f, 14.985f)
                    horizontalLineTo(69.566f)
                    lineTo(69.614f, 14.655f)
                    curveTo(69.629f, 14.55f, 69.636f, 14.44f, 69.637f, 14.327f)
                    curveTo(69.65f, 14.219f, 69.657f, 14.118f, 69.657f, 14.025f)
                    curveTo(69.657f, 13.623f, 69.628f, 13.237f, 69.568f, 12.867f)
                    lineTo(69.6f, 12.848f)
                    horizontalLineTo(69.565f)
                    curveTo(69.455f, 12.179f, 69.247f, 11.564f, 68.936f, 11.006f)
                    curveTo(68.467f, 10.126f, 67.81f, 9.439f, 66.966f, 8.953f)
                    curveTo(66.12f, 8.466f, 65.154f, 8.228f, 64.077f, 8.228f)
                    curveTo(63.012f, 8.228f, 62.04f, 8.474f, 61.17f, 8.972f)
                    curveTo(60.317f, 9.456f, 59.64f, 10.134f, 59.144f, 10.998f)
                    lineTo(59.141f, 11.003f)
                    curveTo(58.656f, 11.873f, 58.418f, 12.865f, 58.418f, 13.966f)
                    curveTo(58.418f, 15.069f, 58.663f, 16.062f, 59.163f, 16.933f)
                    lineTo(59.166f, 16.937f)
                    close()
                    moveTo(60.696f, 13.232f)
                    lineTo(67.451f, 13.232f)
                    curveTo(67.406f, 12.748f, 67.273f, 12.305f, 67.052f, 11.904f)
                    curveTo(66.761f, 11.375f, 66.358f, 10.965f, 65.842f, 10.674f)
                    curveTo(65.34f, 10.37f, 64.752f, 10.218f, 64.078f, 10.218f)
                    curveTo(64.076f, 10.218f, 64.075f, 10.218f, 64.074f, 10.218f)
                    curveTo(64.075f, 10.218f, 64.076f, 10.218f, 64.077f, 10.218f)
                    curveTo(64.752f, 10.218f, 65.34f, 10.37f, 65.842f, 10.674f)
                    curveTo(66.358f, 10.965f, 66.761f, 11.375f, 67.052f, 11.904f)
                    curveTo(67.213f, 12.196f, 67.327f, 12.511f, 67.395f, 12.848f)
                    curveTo(67.42f, 12.973f, 67.439f, 13.101f, 67.451f, 13.232f)
                    horizontalLineTo(60.696f)
                    close()
                    moveTo(64.514f, 17.674f)
                    curveTo(64.514f, 17.674f, 64.514f, 17.674f, 64.514f, 17.674f)
                    curveTo(65.135f, 17.674f, 65.697f, 17.568f, 66.2f, 17.357f)
                    curveTo(66.715f, 17.145f, 67.164f, 16.828f, 67.548f, 16.405f)
                    lineTo(67.548f, 16.405f)
                    curveTo(67.46f, 16.501f, 67.369f, 16.592f, 67.275f, 16.678f)
                    curveTo(66.956f, 16.967f, 66.597f, 17.193f, 66.199f, 17.357f)
                    curveTo(65.697f, 17.568f, 65.135f, 17.674f, 64.514f, 17.674f)
                    close()
                    moveTo(64.147f, 19.334f)
                    curveTo(63.149f, 19.295f, 62.26f, 19.066f, 61.48f, 18.646f)
                    curveTo(60.634f, 18.183f, 59.973f, 17.548f, 59.497f, 16.742f)
                    curveTo(59.034f, 15.936f, 58.803f, 15.01f, 58.803f, 13.966f)
                    curveTo(58.803f, 12.922f, 59.028f, 11.996f, 59.477f, 11.19f)
                    curveTo(59.94f, 10.383f, 60.568f, 9.755f, 61.361f, 9.306f)
                    curveTo(62.163f, 8.846f, 63.062f, 8.615f, 64.06f, 8.612f)
                    curveTo(63.062f, 8.615f, 62.162f, 8.846f, 61.361f, 9.306f)
                    curveTo(60.568f, 9.755f, 59.94f, 10.383f, 59.477f, 11.19f)
                    curveTo(59.028f, 11.996f, 58.803f, 12.922f, 58.803f, 13.966f)
                    curveTo(58.803f, 15.01f, 59.034f, 15.936f, 59.497f, 16.742f)
                    curveTo(59.973f, 17.548f, 60.634f, 18.183f, 61.48f, 18.646f)
                    curveTo(62.26f, 19.066f, 63.149f, 19.295f, 64.147f, 19.334f)
                    close()
                    moveTo(66.715f, 12.089f)
                    curveTo(66.844f, 12.323f, 66.94f, 12.576f, 67.002f, 12.848f)
                    horizontalLineTo(61.154f)
                    curveTo(61.219f, 12.582f, 61.315f, 12.336f, 61.44f, 12.109f)
                    lineTo(61.442f, 12.105f)
                    curveTo(61.7f, 11.625f, 62.052f, 11.263f, 62.501f, 11.009f)
                    lineTo(62.505f, 11.007f)
                    lineTo(62.508f, 11.005f)
                    curveTo(62.958f, 10.74f, 63.478f, 10.602f, 64.077f, 10.602f)
                    curveTo(64.692f, 10.602f, 65.209f, 10.74f, 65.643f, 11.003f)
                    lineTo(65.648f, 11.006f)
                    lineTo(65.653f, 11.009f)
                    curveTo(66.105f, 11.264f, 66.458f, 11.621f, 66.715f, 12.089f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd,
                ) {
                    moveTo(93.885f, 6.023f)
                    horizontalLineTo(91.213f)
                    verticalLineTo(8.324f)
                    horizontalLineTo(89.428f)
                    verticalLineTo(10.659f)
                    horizontalLineTo(91.213f)
                    verticalLineTo(16.045f)
                    curveTo(91.213f, 17.174f, 91.525f, 18.098f, 92.201f, 18.759f)
                    curveTo(92.874f, 19.417f, 93.802f, 19.721f, 94.928f, 19.721f)
                    curveTo(95.399f, 19.721f, 95.853f, 19.657f, 96.286f, 19.527f)
                    curveTo(96.743f, 19.394f, 97.143f, 19.185f, 97.48f, 18.894f)
                    lineTo(97.694f, 18.709f)
                    lineTo(96.782f, 16.611f)
                    lineTo(96.388f, 16.939f)
                    curveTo(96.071f, 17.204f, 95.666f, 17.346f, 95.146f, 17.346f)
                    curveTo(94.696f, 17.346f, 94.399f, 17.22f, 94.198f, 17.012f)
                    curveTo(94.008f, 16.802f, 93.885f, 16.472f, 93.885f, 15.966f)
                    verticalLineTo(10.659f)
                    horizontalLineTo(96.899f)
                    verticalLineTo(8.324f)
                    horizontalLineTo(93.885f)
                    verticalLineTo(6.023f)
                    close()
                    moveTo(89.812f, 8.708f)
                    lineTo(89.813f, 8.708f)
                    verticalLineTo(10.275f)
                    lineTo(89.812f, 10.275f)
                    verticalLineTo(8.708f)
                    close()
                    moveTo(91.597f, 10.275f)
                    verticalLineTo(16.045f)
                    curveTo(91.597f, 17.103f, 91.888f, 17.916f, 92.469f, 18.484f)
                    curveTo(93.051f, 19.052f, 93.871f, 19.337f, 94.928f, 19.337f)
                    curveTo(94.94f, 19.337f, 94.952f, 19.337f, 94.964f, 19.337f)
                    curveTo(94.952f, 19.337f, 94.94f, 19.337f, 94.929f, 19.337f)
                    curveTo(93.871f, 19.337f, 93.051f, 19.052f, 92.47f, 18.484f)
                    curveTo(91.888f, 17.916f, 91.597f, 17.103f, 91.597f, 16.045f)
                    verticalLineTo(10.275f)
                    lineTo(91.597f, 10.275f)
                    close()
                    moveTo(95.159f, 17.73f)
                    curveTo(95.597f, 17.729f, 95.981f, 17.637f, 96.311f, 17.455f)
                    curveTo(96.425f, 17.393f, 96.532f, 17.319f, 96.634f, 17.235f)
                    lineTo(96.634f, 17.235f)
                    curveTo(96.24f, 17.563f, 95.748f, 17.728f, 95.159f, 17.73f)
                    close()
                    moveTo(91.597f, 6.408f)
                    verticalLineTo(8.708f)
                    lineTo(91.597f, 8.708f)
                    verticalLineTo(6.408f)
                    lineTo(91.597f, 6.408f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(84.978f, 6.652f)
                    arcToRelative(1.538f, 1.538f, 0.0f, true, false, 3.075f, 0.0f)
                    arcToRelative(1.538f, 1.538f, 0.0f, true, false, -3.075f, 0.0f)
                    close()
                }
            }
        }
            .build()
        return _logo!!
    }

private var _logo: ImageVector? = null
