package com.dkin.chevit.presentation.step.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.step.component.ChevitTabRowDefaults.chevitTabIndicatorOffset

@Composable
fun ChevitTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    indicator: @Composable (tabPositions: List<ChevitTabRowDefaults.TabPosition>) -> Unit = @Composable { tabPositions ->
        ChevitTabRowDefaults.Indicator(
            Modifier.chevitTabIndicatorOffset(tabPositions[selectedTabIndex])
        )
    },
    divider: @Composable () -> Unit = @Composable {
        Divider(thickness = 4.dp, color = ChevitTheme.colors.grey2)
    },
    tabs: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.selectableGroup(),
        color = Color.Transparent,
        contentColor = ChevitTheme.colors.blue7
    ) {
        SubcomposeLayout(Modifier.fillMaxWidth()) { constraints ->
            val tabRowWidth = constraints.maxWidth
            val tabMeasurable = subcompose(TabSlots.Tabs, tabs)
            val tabCount = tabMeasurable.size
            val tabWidth = (tabRowWidth / tabCount)
            val tabRowHeight = 4.dp.toPx().toInt()

            val tabPositions = List(tabCount) { index ->
                ChevitTabRowDefaults.TabPosition(tabWidth.toDp() * index, tabWidth.toDp())
            }

            layout(tabRowWidth, tabRowHeight) {
                subcompose(TabSlots.Divider, divider).forEach {
                    val placeable = it.measure(constraints.copy(minHeight = 0))
                    placeable.placeRelative(0, tabRowHeight - placeable.height)
                }
                subcompose(TabSlots.Indicator) {
                    indicator(tabPositions)
                }.forEach {
                    it.measure(Constraints.fixed(tabRowWidth, tabRowHeight)).placeRelative(0, 0)
                }
            }
        }
    }
}

private enum class TabSlots {
    Tabs,
    Divider,
    Indicator
}

object ChevitTabRowDefaults {
    @Composable
    fun Indicator(
        modifier: Modifier = Modifier,
        height: Dp = 4.dp,
        color: Color = ChevitTheme.colors.blue7
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .height(height)
                .background(color = color)
        )
    }

    @Immutable
    class TabPosition internal constructor(val left: Dp, val width: Dp) {
        val right: Dp get() = left + width

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is TabPosition) return false

            if (left != other.left) return false
            if (width != other.width) return false

            return true
        }

        override fun hashCode(): Int {
            var result = left.hashCode()
            result = 31 * result + width.hashCode()
            return result
        }

        override fun toString(): String {
            return "TabPosition(left=$left, right=$right, width=$width)"
        }
    }

    fun Modifier.chevitTabIndicatorOffset(
        currentTabPosition: TabPosition
    ): Modifier = composed(
        inspectorInfo = debugInspectorInfo {
            name = "tabIndicatorOffset"
            value = currentTabPosition
        }
    ) {
        val currentTabWidth by animateDpAsState(
            targetValue = currentTabPosition.width,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
        )
        val indicatorOffset by animateDpAsState(
            targetValue = currentTabPosition.left,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
        )
        fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset(x = indicatorOffset)
            .width(currentTabWidth)
    }
}

