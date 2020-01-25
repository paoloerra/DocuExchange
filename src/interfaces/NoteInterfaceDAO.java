package interfaces;

import java.io.InputStream;
import java.util.ArrayList;

public interface NoteInterfaceDAO {

	public boolean saveRequest(NoteInterface request);
	public ArrayList<NoteInterface> selectNote();
	public ArrayList<NoteInterface> selectNoteStudent(String email);
	public ArrayList<NoteInterface> selectMyNote(String email);
	public ArrayList<NoteInterface> SearchNote(String course, String professor);
	public ArrayList<NoteInterface> selectRequest();
	public boolean UpdateRequestAccept(String id);
	public boolean UpdateRequestRifiuted(String id);
	public ArrayList<NoteInterface> selectSearchRequest(String autor);
	public InputStream DownloadNote(String id);












}
