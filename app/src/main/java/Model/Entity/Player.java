package Model.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Tsubasa on 2016/11/01.
 */
@DatabaseTable(tableName = "player")
public class Player {

	@DatabaseField(generatedId = true)
	private Integer id;
	@DatabaseField
	private String value;

	public Player() {
	}

	public Player(String value) {
		this.value = value;
	}

	public Integer getId() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
