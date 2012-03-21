package com.nature.application.jsf.navigator;

import java.net.URL;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ApplicationScoped
public class NavigationParser {
    private List<GroupDescriptor> groupsList;

    @XmlRootElement(name = "root")
    private static final class GroupsHolder {
        private List<GroupDescriptor> groups;

        @XmlElement(name = "group")
        public List<GroupDescriptor> getGroups() {
            return groups;
        }

        @SuppressWarnings("unused")
        public void setGroups(List<GroupDescriptor> groups) {
            this.groups = groups;
        }
    }

    public synchronized List<GroupDescriptor> getGroupsList() {
        if (groupsList == null) {
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            URL resource = ccl.getResource("com/nature/application/jsf/navigator/navigation.xml");
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(GroupsHolder.class);
                GroupsHolder groupsHolder = (GroupsHolder) context.createUnmarshaller().unmarshal(resource);
                groupsList = groupsHolder.getGroups();
            } catch (JAXBException e) {
                throw new FacesException(e.getMessage(), e);
            }
        }

        return groupsList;
    }
}
