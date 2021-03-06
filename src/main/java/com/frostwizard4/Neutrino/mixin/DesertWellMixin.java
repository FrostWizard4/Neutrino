package com.frostwizard4.Neutrino.mixin;

import com.frostwizard4.Neutrino.registry.BlockRegistry;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.DesertWellFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DesertWellFeature.class)
public abstract class DesertWellMixin extends Feature<DefaultFeatureConfig> {

    public DesertWellMixin(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Inject(at = @At("RETURN"), method = "generate")
    public void addTerracottaPot(FeatureContext<DefaultFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();

        structureWorldAccess.setBlockState(blockPos.add(0, -2, 0), BlockRegistry.SWORD_SHRINE.getDefaultState(), Block.NOTIFY_LISTENERS);
    }
}