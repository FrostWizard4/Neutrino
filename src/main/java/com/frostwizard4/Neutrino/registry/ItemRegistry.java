package com.frostwizard4.Neutrino.registry;

import com.frostwizard4.Neutrino.armor.FurArmorMaterial;
import com.frostwizard4.Neutrino.artifacts.*;
import com.frostwizard4.Neutrino.items.*;
import com.frostwizard4.Neutrino.misc.LifeStealEnchantment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static com.frostwizard4.Neutrino.NeutrinoMain.NEUTRINO_DUNGEONS_GROUP;
import static com.frostwizard4.Neutrino.NeutrinoMain.NEUTRINO_GROUP;

public class ItemRegistry {
    public static final EnchantersTomeArtifact ENCHANTERS_TOME = new EnchantersTomeArtifact(new FabricItemSettings().group(NEUTRINO_DUNGEONS_GROUP).rarity(Rarity.RARE));
    public static final HarvesterArtifact HARVESTER = new HarvesterArtifact(new FabricItemSettings().group(NEUTRINO_DUNGEONS_GROUP).rarity(Rarity.RARE));
    public static final LightningRodArtifact LIGHTNING_ROD_ARTIFACT = new LightningRodArtifact(new FabricItemSettings().group(NEUTRINO_DUNGEONS_GROUP).rarity(Rarity.RARE));
    public static final UpdraftTomeArtifact UPDRAFT_TOME = new UpdraftTomeArtifact(new FabricItemSettings().group(NEUTRINO_DUNGEONS_GROUP).rarity(Rarity.RARE));
    public static final SoulHealerArtifact SOUL_HEALER = new SoulHealerArtifact(new FabricItemSettings().group(NEUTRINO_DUNGEONS_GROUP).rarity(Rarity.RARE));
    public static final SoulPouchItem SOUL_POUCH = new SoulPouchItem(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.EPIC));
    public static final GoatHorn GOAT_HORN = new GoatHorn(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.COMMON));
    public static final Enchantment LIFE_STEAL = Registry.register(Registry.ENCHANTMENT, new Identifier("neutrino", "life_steal"), new LifeStealEnchantment());
    public static final ToolItem RUSTY_SWORD = new SwordItem(RustySwordMaterial.INSTANCE, 1, -1.0F, new Item.Settings().group(NEUTRINO_GROUP));
    public static final ToolItem SHATTERED_SWORD = new SwordItem(ShatteredSwordMaterial.INSTANCE, 2, -1.5F, new Item.Settings().group(NEUTRINO_GROUP));
    public static final EmptyStaff EMPTY_STAFF = new EmptyStaff(new FabricItemSettings().group(NEUTRINO_GROUP));
    public static final EvokersStaff EVOKERS_STAFF = new EvokersStaff(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.EPIC));
    public static final Item GRAY_JEWEL = new Item(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.RARE));
    public static final VampiricStaff VAMPIRIC_STAFF = new VampiricStaff(ToolMaterials.STONE, 1, 3, new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.RARE));
    public static final DaturaEssence DATURA_ESSENCE = new DaturaEssence(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.COMMON));
    public static final Item DUCK_FEATHER = new Item(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.COMMON));
    public static final Item WITHERING_HEART = new Item(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.EPIC));
    public static final Item WITHERING_HEART_FRAGMENT = new Item(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.RARE));
    public static final Item ALPACA_FUR = new Item(new FabricItemSettings().group(NEUTRINO_GROUP).rarity(Rarity.COMMON));
    public static final ArmorMaterial FUR_ARMOR_MATERIAL = new FurArmorMaterial();
    public static final Item ALPACA_FUR_SWEATER = new ArmorItem(FUR_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(NEUTRINO_GROUP));

    public static void init() {

        Registry.register(Registry.ITEM, new Identifier("neutrino", "enchanters_tome"), ENCHANTERS_TOME);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "harvester"), HARVESTER);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "lightning_rod_artifact"), LIGHTNING_ROD_ARTIFACT);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "updraft_tome"), UPDRAFT_TOME);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "soul_healer"), SOUL_HEALER);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "soul_pouch"), SOUL_POUCH);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "goat_horn"), GOAT_HORN);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "rusty_sword"), RUSTY_SWORD);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "shattered_sword"), SHATTERED_SWORD);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "empty_staff"), EMPTY_STAFF);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "evokers_staff"), EVOKERS_STAFF);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "gray_jewel"), GRAY_JEWEL);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "vampiric_staff"), VAMPIRIC_STAFF);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "datura_essence"), DATURA_ESSENCE);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "duck_feather"), DUCK_FEATHER);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "withering_heart"), WITHERING_HEART);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "withering_heart_fragment"), WITHERING_HEART_FRAGMENT);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "alpaca_fur"), ALPACA_FUR);
        Registry.register(Registry.ITEM, new Identifier("neutrino", "alpaca_fur_sweater"), ALPACA_FUR_SWEATER);
    }
}