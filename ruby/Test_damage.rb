# coding: utf-8
module Test 

  require_relative 'WeaponType'
  require_relative 'Weapon'
  require_relative 'ShieldBooster'  
  require_relative 'Damage'
  
  class Damage

    def self.test
      # ______ constructores ___-
      puts "____ constructores _____"
      numeric = Deepspace::Damage.newNumericWeapons 2,3
      puts numeric.to_s
      
      weapons_types = Array.new 3 ,Deepspace::WeaponType::LASER
      specific = Deepspace::Damage.newSpecificWeapons weapons_types, 9
      puts specific.to_s

      copy = Deepspace::Damage.newCopy specific
      puts copy.to_s


      #___ dicard methods _____
      puts "#___ dicard methods _____"
      copy.discardWeapon Deepspace::WeaponType::LASER
      puts copy.to_s
      numeric.discardWeapon Deepspace::WeaponType::LASER
      #puts numeric.to_s
      numeric.discardShieldBooster
      puts numeric.to_s

      #___ arrayContains (COMO ES PRIVADO LO PONGO COMO COMENTARIO )____

=begin
      puts "____ arrayContains____"
      # creación array auxiliar 
      weapons_array = Array.new
      weapons_array << Deepspace::Weapon.new("lasecillo",
                                             Deepspace::WeaponType::LASER,
                                             3)
      weapons_array << Deepspace::Weapon.new("plasmilla",
                                             Deepspace::WeaponType::PLASMA,                                       
                                             4)

      puts "PLAMA se encuentra en #{ Deepspace::Damage.arrayContainsType(weapons_array, Deepspace::WeaponType::PLASMA)}"
      puts "LASER se encuentra en #{ Deepspace::Damage.arrayContainsType(weapons_array, Deepspace::WeaponType::LASER)}"
      puts "MISSILE se encuentra en #{ Deepspace::Damage.arrayContainsType(weapons_array, Deepspace::WeaponType::MISSILE)}"
      
=end


      #_____adjust____
      puts "________ADJUST______"
      for i in 0..2
        weapons_array = Array.new
        weapons_array << Deepspace::Weapon.new("lasecillo",
                                               Deepspace::WeaponType::LASER,
                                               3)
        weapons_array << Deepspace::Weapon.new("plasmilla",
                                               Deepspace::WeaponType::PLASMA,                                       
                                               4)
        weapons_array << Deepspace::Weapon.new("plasmilla 2",
                                               Deepspace::WeaponType::PLASMA,                                       
                                               1)

        shield_array = Array.new
        shield_array << Deepspace::ShieldBooster.new("escudo 1", 2.1, 1)
        shield_array << Deepspace::ShieldBooster.new("escudo 2", 9.1, 3)

        if i == 0 # caso de prueba más escudos, borramos laser
          puts "CASO 0: más escudos, borramos plasma"
          weapons_types = Array.new 3 ,Deepspace::WeaponType::LASER
          specific = Deepspace::Damage.newSpecificWeapons weapons_types, 9

          puts "--El objeto ajustado--"
          puts specific.adjust(weapons_array, shield_array).to_s
          puts "--las armas y escudos tras ajustar--"
          puts weapons_array
          puts shield_array
      
        elsif i==1
        else
        end #switch case
      end
    end
    

    

    
  end # Test_Damage 
   

end #module Deepspace 


Test::Damage.test
