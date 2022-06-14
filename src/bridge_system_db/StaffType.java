package bridge_system_db;

public enum StaffType {
	superadmin,admin,tollclerk,officer;
	public static StaffType fromInteger(int x) {
        switch(x) {
        case 0:
            return superadmin;
        case 1:
            return admin;
        case 2:
        	return tollclerk;
        case 3: 
        	return officer;
        }
        return null;
    }
	public static int toInteger(StaffType type) {
		switch(type) {
        case superadmin:
            return 0;
        case admin:
            return 1;
        case tollclerk:
        	return 2;
        case officer: 
        	return 3;
        }
        return -1;
	}
}
