package hello.Dal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import hello.Models.*;

@Repository
public class TagRepository {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	public int insertTag(Tag tag)
        {
            int tagid=jdbcTemplate.queryForObject(
                    "call proc_Tag_insert(?,?,?,?,?);",
                    Integer.class
                    ,tag.getName(),tag.getDescription(),tag.getStatus(),tag.getCreated_date(),tag.getUpdated_date() );
            return tagid;
            
        }
        
        public Tag getTag_by_id(int id)
        {
            return new Tag();
        }
	
}
