import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;

public class MainWindow {

	public JFrame frmAgileGlossary;
	private JTable tblTermList;
	private JTextField txtSearch;
		
	public static enum WindowType { ADD, EDIT };
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmAgileGlossary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgileGlossary = new JFrame();
		frmAgileGlossary.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		frmAgileGlossary.setTitle("Agile Glossary");
		frmAgileGlossary.setBounds(100, 100, 450, 300);
		frmAgileGlossary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgileGlossary.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 412, 211);
		frmAgileGlossary.getContentPane().add(scrollPane);
		
		tblTermList = new JTable() {
			
			static final long serialVersionUID = 1;
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
			
		};
		tblTermList.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		tblTermList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (e.getClickCount() == 2) {
	                JTable target = (JTable) e.getSource();
	                int row = target.getSelectedRow();
	               
	                int fieldsCount = target.getColumnCount();   
	                String[] termFields = new String[fieldsCount];
	                for (int i = 0; i < fieldsCount; ++i) {
	                	
	                	termFields[i] = target.getValueAt(row, i).toString();
	                	
	                }
	                Term newTerm = getTerm(termFields);
	                
	                showAddEditWindow(WindowType.EDIT, newTerm);
	             }
			}
	       });
		scrollPane.setViewportView(tblTermList);
		fillJTable();
		renameJTableColumns();
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAddEditWindow(WindowType.ADD, null);
			}
		});
		button.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		button.setBounds(346, 228, 76, 23);
		frmAgileGlossary.getContentPane().add(button);
		
		txtSearch = new JTextField();
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtSearch.setText("");
			}
		});
		txtSearch.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(48, 228, 288, 22);
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				search();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				search();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				search();
			}
			
			 public void search() {
			     
				 String searchText = txtSearch.getText().trim();
			     
			     TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tblTermList.getModel())); 
				 sorter.setRowFilter(RowFilter.regexFilter(searchText));

				 tblTermList.setRowSorter(sorter);
			  }
			 
		});
		
		frmAgileGlossary.getContentPane().add(txtSearch);
		
		JLabel label = new JLabel("Search");
		label.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		label.setBounds(10, 233, 33, 14);
		frmAgileGlossary.getContentPane().add(label);
		
		centerFrame(frmAgileGlossary);
	}
	
	public static void centerFrame(Window frame) {
	    frame.setLocationRelativeTo(null);
	}
	
	private void showAddEditWindow(WindowType type, Term newTerm) {
		
		frmAgileGlossary.dispose();
		AddEditWindow addWindow = null;
		
		if (type == WindowType.ADD) {
			
			addWindow = new AddEditWindow(type, null);
			
		} else {
			
			addWindow = new AddEditWindow(type, newTerm);
			
		}
		
		addWindow.setVisible(true);
		
	}
	
	private void fillJTable() {
		
		ResultSet termList = DBHandler.getTermList();
		
		tblTermList.setModel(DbUtils.resultSetToTableModel(termList));
		
		removeIDColumn();
		
	}
	
	private void removeIDColumn() {
		
		TableColumnModel tcm = tblTermList.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
		
	}
	
	private void renameJTableColumns() {
		
		String[] columnHeaders = new String[] { "Term", "Transcription", "Description" };
		final int columnNumber = tblTermList.getColumnCount();
		
		for (int i = 0; i < columnNumber; ++i) {
			
			renameJTableColumn(i, columnHeaders[i]);
			
		}
		
		tblTermList.getTableHeader().repaint();
		
	}
	
	private void renameJTableColumn(int columnID, String columnHeader) {
		
		tblTermList.getColumnModel().getColumn(columnID).setHeaderValue(columnHeader);
		
	}
	
	private Term getTerm(String[] termFields) {
		
		Term newTerm = new Term(termFields[0].trim(), termFields[1].trim(), termFields[2].trim());
		
		return newTerm;
		
	}
}
