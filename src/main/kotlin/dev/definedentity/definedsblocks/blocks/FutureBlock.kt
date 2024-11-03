package dev.definedentity.definedsblocks.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.util.StringRepresentable
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.EnumProperty
import net.minecraft.world.level.material.Material

class FutureBlock :
    Block(FabricBlockSettings.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f)) {
    companion object {
        val ID = "future_block"
        val FUTURE_BLOCK_TYPE = EnumProperty.create("type", FutureBlockType::class.java)
    }

    init {
        registerDefaultState(defaultBlockState().setValue(FUTURE_BLOCK_TYPE, FutureBlockType.block))
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block?, BlockState?>) {
        builder.add(FUTURE_BLOCK_TYPE)
    }

    enum class FutureBlockType : StringRepresentable {
        block,
        column_x,
        column_y,
        column_z;

        override fun getSerializedName(): String {
            return name
        }
    }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState {
        return getControllerType(defaultBlockState(), context.level, context.clickedPos)
    }

    override fun updateShape(
        state: BlockState,
        direction: Direction,
        neighborState: BlockState,
        level: LevelAccessor,
        currentPos: BlockPos,
        neighborPos: BlockPos
    ): BlockState {
        return getControllerType(state, level, currentPos)
    }

    fun getControllerType(baseState: BlockState, level: LevelAccessor, pos: BlockPos): BlockState {
        var type = FutureBlockType.block

        val x = pos.x
        val y = pos.y
        val z = pos.z

        val xx = isFutureBlock(level, x - 1, y, z) && isFutureBlock(level, x + 1, y, z)
        val yy = isFutureBlock(level, x, y - 1, z) && isFutureBlock(level, x, y + 1, z)
        val zz = isFutureBlock(level, x, y, z - 1) && isFutureBlock(level, x, y, z + 1)

        if (xx && !yy && !zz) {
            type = FutureBlockType.column_x
        } else if (!xx && yy && !zz) {
            type = FutureBlockType.column_y
        } else if (!xx && !yy && zz) {
            type = FutureBlockType.column_z
        }

        return baseState.setValue(FUTURE_BLOCK_TYPE, type)
    }

    fun isFutureBlock(level: LevelAccessor, x: Int, y: Int, z: Int): Boolean {
        return level.getBlockState(BlockPos(x, y, z)).`is`(DBBlocks.FUTURE_BLOCK)
    }
}