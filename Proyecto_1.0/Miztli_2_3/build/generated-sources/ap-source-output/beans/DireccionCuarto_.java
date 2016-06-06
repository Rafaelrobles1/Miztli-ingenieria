package beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DireccionCuarto.class)
public abstract class DireccionCuarto_ {

	public static volatile SingularAttribute<DireccionCuarto, String> calleC;
	public static volatile SingularAttribute<DireccionCuarto, Integer> codigoPostalC;
	public static volatile ListAttribute<DireccionCuarto, TieneDireccionC> tieneDireccionCList;
	public static volatile SingularAttribute<DireccionCuarto, Integer> idDireccionC;
	public static volatile SingularAttribute<DireccionCuarto, String> delegacionC;
	public static volatile SingularAttribute<DireccionCuarto, String> coloniaC;
	public static volatile SingularAttribute<DireccionCuarto, String> linkUbicacion;

}

