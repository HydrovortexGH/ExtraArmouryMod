package net.hydrovortex.extraarmoury.item.custom;

import net.hydrovortex.extraarmoury.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class MaletItem extends Item {
    private static final Map<Block,Block> MALET_MAP =
            Map.of(
                    ModBlocks.Unrefined_Superior_Block.get(), ModBlocks.Superior_Block.get()

            );


    public MaletItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(MALET_MAP.containsKey(clickedBlock)){
           if(!level.isClientSide()) {
               level.setBlockAndUpdate(pContext.getClickedPos(), MALET_MAP.get(clickedBlock).defaultBlockState());

               pContext.getItemInHand().hurtAndBreak(1,((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND)
               );

               level.playSound(null, pContext.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS);
           }
        }


        return InteractionResult.SUCCESS;
    }
}
