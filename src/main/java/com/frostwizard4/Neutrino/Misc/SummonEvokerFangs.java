package com.frostwizard4.Neutrino.Misc;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;

public class SummonEvokerFangs {
    public static void summonFangs(Entity entity) {
        double d = entity.getY();
        double e = entity.getY() + 1;
        float f = entity.getHeadYaw() + 180;
        int j;
        if (entity.isSneaking()) {
            float h;
            for(j = 0; j < 5; ++j) {
                h = f + (float)j * 3.1415927F * 0.4F;
                conjureFangs(entity, entity.getX() + (double)MathHelper.cos(h) * 1.5D, entity.getZ() + (double)MathHelper.sin(h) * 1.5D, d, e, h, 0);
            }

            for(j = 0; j < 8; ++j) {
                h = f + (float)j * 3.1415927F * 2.0F / 8.0F + 1.2566371F;
                conjureFangs(entity,entity.getX() + (double)MathHelper.cos(h) * 2.5D, entity.getZ() + (double)MathHelper.sin(h) * 2.5D, d, e, h, 3);
            }
        } else {
            Vec3d vector3f = fromPolar(entity.getPitch(0.0f), entity.getHeadYaw());
            for (j = 0; j < 8; ++j) {
                double l = 1.25D * (double) (j + 1);
                conjureFangs(entity, entity.getX() + vector3f.getX() * l, entity.getZ() + vector3f.getZ() * l, d, e, f, j);
            }
        }
    }
    private static void conjureFangs(Entity entity, double x, double z, double maxY, double y, float yaw, int warmup) {
        BlockPos blockPos = new BlockPos(x, y, z);
        boolean bl = false;
        double d = 0.0D;

        do {
            BlockPos blockPos2 = blockPos.down();
            BlockState blockState = entity.world.getBlockState(blockPos2);
            if (blockState.isSideSolidFullSquare(entity.world, blockPos2, Direction.UP)) {
                if (!entity.world.isAir(blockPos)) {
                    BlockState blockState2 = entity.world.getBlockState(blockPos);
                    VoxelShape voxelShape = blockState2.getCollisionShape(entity.world, blockPos);
                    if (!voxelShape.isEmpty()) {
                        d = voxelShape.getMax(Direction.Axis.Y);
                    }
                }

                bl = true;
                break;
            }

            blockPos = blockPos.down();
        } while(blockPos.getY() >= MathHelper.floor(maxY) - 1);

        if (bl) {
            entity.world.spawnEntity(new EvokerFangsEntity(entity.world, x, (double)blockPos.getY() + d, z, yaw, warmup, (LivingEntity) entity));
        }

    }
    public static Vec3d fromPolar(float pitch, float yaw) {
        float f = MathHelper.cos(-yaw * 0.017453292F - 3.1415927F);
        float g = MathHelper.sin(-yaw * 0.017453292F - 3.1415927F);
        float h = -MathHelper.cos(-pitch * 0.017453292F);
        float i = MathHelper.sin(-pitch * 0.017453292F);
        return new Vec3d((double)(g * h), (double)i, (double)(f * h));
    }
}