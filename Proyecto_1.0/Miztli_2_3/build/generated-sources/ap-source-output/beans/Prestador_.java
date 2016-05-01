package beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Prestador.class)
public abstract class Prestador_ {

	public static volatile SingularAttribute<Prestador, byte[]> fotoU;
	public static volatile SingularAttribute<Prestador, String> apellidoPaterno;
	public static volatile ListAttribute<Prestador, TieneContratoU> tieneContratoUList;
	public static volatile SingularAttribute<Prestador, String> contrasenyav;
	public static volatile SingularAttribute<Prestador, Integer> idUsuario;
	public static volatile SingularAttribute<Prestador, Integer> cuartosDisponibles;
	public static volatile SingularAttribute<Prestador, String> CodigoPostalU;
	public static volatile SingularAttribute<Prestador, String> contrasenya;
	public static volatile ListAttribute<Prestador, TieneCuarto> tieneCuartoList;
	public static volatile SingularAttribute<Prestador, String> nombre;
	public static volatile SingularAttribute<Prestador, String> paisU;
	public static volatile SingularAttribute<Prestador, String> estadoU;
	public static volatile SingularAttribute<Prestador, String> delegacionU;
	public static volatile SingularAttribute<Prestador, String> apellidoMaterno;
	public static volatile SingularAttribute<Prestador, String> correo;
	public static volatile SingularAttribute<Prestador, String> calleU;
	public static volatile SingularAttribute<Prestador, String> telefono;
	public static volatile SingularAttribute<Prestador, String> coloniaU;

}

