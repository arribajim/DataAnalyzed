package mx.gw.analitic.extensions;

public class TypekeyDTO extends EntityDTO{
	@Override
	public String toString() {
//		return "TypekeyDTO [code=" + code + ", getEntityName()=" + getEntityName() + ", getTag()=" + getTag()
//				+ ", getName()=" + getName() + ", getDescription()=" + getDescription() + "]";
		return  getEntityName()+ "\t" + getTag()+"\t" + code + "\t" + getName()+ "\t" + getDescription();
	}

	private String code;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof TypekeyDTO))
			return false;
		TypekeyDTO other = (TypekeyDTO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
