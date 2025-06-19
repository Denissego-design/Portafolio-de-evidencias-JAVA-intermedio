import java.util.List;

abstract class OrdenProduccion {
        protected String codigo;
        protected String cliente;
        protected int cantidad;

        public OrdenProduccion(String codigo, int cantidad) {
            this.codigo = codigo;
            this.cantidad = cantidad;
        }

        public void mostrarResumen() {
            System.out.println("Código: " + codigo + " | Cantidad: " + cantidad);
        }
    }

    class OrdenMasa extends OrdenProduccion {
        public OrdenMasa(String codigo, int cantidad) {
            super(codigo, cantidad);
        }
    }

    class OrdenPersonalizada extends OrdenProduccion {

        private String cliente;

        public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
            super(codigo, cantidad);
            this.cliente = cliente;
        }

        @Override
        public void mostrarResumen() {
            System.out.println("Código: " + codigo + " | Cantidad: " + cantidad + " | Cliente: " + cliente);
        }
    }

    class OrdenPrototipo extends OrdenProduccion {
        private String faseDesarrollo;

        public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
            super(codigo, cantidad);
            this.faseDesarrollo = faseDesarrollo;
        }

        @Override
        public void mostrarResumen() {
            System.out.println("Código: " + codigo + " | Cantidad: " + cantidad + " | Fase de Desarrollo: " + faseDesarrollo);
        }
    }

