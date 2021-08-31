package com.frostwizard4.Neutrino.Artifacts;

import com.frostwizard4.Neutrino.NeutrinoMain;
import net.minecraft.block.LightningRodBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.SummonCommand;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Target;
import java.util.List;

import static com.frostwizard4.Neutrino.SoundRegister.EAT_DEATH_CAP_MUSHROOM;

public class DeathCapArtifact extends Item {
    public DeathCapArtifact(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        //Play Sound
        playerEntity.playSound(EAT_DEATH_CAP_MUSHROOM, 1.0F, 1.0F);
        //Apply Effects
        world.getClosestPlayer(playerEntity,15).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,50, 2));
        world.getClosestPlayer(playerEntity,15).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 50,1));
        //Set 30 second Cooldown
        playerEntity.getItemCooldownManager().set(NeutrinoMain.DEATH_CAP_MUSHROOM, 600);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.neutrino.death_cap_mushroom.tooltip").formatted(Formatting.AQUA));
        tooltip.add(new TranslatableText("item.neutrino.death_cap_mushroom.tooltip2").formatted(Formatting.AQUA));
        tooltip.add(new TranslatableText("item.neutrino.death_cap_mushroom.tooltip3").formatted(Formatting.AQUA));
    }

    @Override
    public boolean isFood() {
        return super.isFood();
    }
}