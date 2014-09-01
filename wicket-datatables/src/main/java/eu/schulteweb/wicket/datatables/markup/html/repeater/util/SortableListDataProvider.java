package eu.schulteweb.wicket.datatables.markup.html.repeater.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.core.util.lang.PropertyResolver;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

public class SortableListDataProvider<T extends Serializable> extends SortableDataProvider<T, String> {

	private ListModel<T> listModel;

	public SortableListDataProvider(List<T> list) {
		this(new ListModel<T>(list));
	}

	public SortableListDataProvider(ListModel<T> listModel) {
		this.listModel = listModel;
	}

	@Override
	public Iterator<? extends T> iterator(long first, long count) {
		List<T> list = listModel.getObject();
		
		Collections.sort(listModel.getObject(), newComparator());

		long toIndex = first + count;
		
		if (toIndex > list.size()) {
			toIndex = list.size();
		}
		
		return list.subList((int) first, (int) toIndex).listIterator();
	}
	
	protected Comparator<T> newComparator() {
		return new Comparator<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(T o1, T o2) {
				Object sortProperty1 = PropertyResolver.getValue("", o1);
				Object sortProperty2 = PropertyResolver.getValue("", o2);
				
				if(sortProperty1 instanceof Comparable<?> && sortProperty2 instanceof Comparable<?>) {
					return ((Comparable<Object>)sortProperty1).compareTo((Comparable<Object>)sortProperty2);
				}
				
				return 0;
			}
		};
	}

	@Override
	public long size() {
		return listModel.getObject().size();
	}

	@Override
	public IModel<T> model(T object) {
		return new Model<T>(object);
	}

	@Override
	public void detach() {
		listModel.detach();
	}

}