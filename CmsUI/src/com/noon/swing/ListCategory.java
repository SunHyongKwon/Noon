
package com.noon.swing;

import com.noon.event.EventCategorySelected;
import com.noon.model.Model_Category;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListCategory<E extends Object> extends JList<E>{
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private EventCategorySelected event;
    
    public void addEventCategorySelected(EventCategorySelected event){
        this.event = event;
    }
    
    // 모델에 데이터를 넣어서 그걸 리스트에 보여준다는 의미로 보면된다.
    // 1번
    public ListCategory() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if(o instanceof Model_Category){
                        Model_Category data = (Model_Category) o;
                        // empty는 선택한 열이 selectedIndex로 안간다는 말이다.
                        if(data.getType() == Model_Category.CategoryType.SUBCATEGORY || data.getType() == Model_Category.CategoryType.CATEGORY){
                            selectedIndex = index;
                            if(event != null){
                                event.selected(index);
                            }
                        }
                    }else{
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
            
        });
        
    }
    
    // categoryitem을 만들어서 반환한다.
    // 3번
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Model_Category data;
                if( value instanceof Model_Category){
                    data = (Model_Category) value;
                }else{
                    data = new Model_Category("",value+"",Model_Category.CategoryType.EMPTY);
                }
                CategoryItem item = new CategoryItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }
            
        };
    }
    
    // 2번
    public void addItem(Model_Category data){
        model.addElement(data);
    }
    
    
}

// list 옮기면 model에 들어가 있는 값을 지우는 거 잊지 않기