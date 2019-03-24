module Deepspace
  module WeaponType

    # @brief  Representa a los tipos de armas del juego.
    #         cada valor posible del tipoenumerado tendrá asociado un valor
    #         numérico concreto igual a la potencia de disparo de cada tipode arma.
    class Type
      # consultor power
      attr_reader :power # equivalente a devolver @power

      def initialize ( _power)
        @power= _power
      end # initialize

    end # class Type

    LASER= Type.new(2.0)
    MISSILE= Type.new(3.0)
    PLASMA= Type.new(4.0)
  end # module weapon
end
