<<<<<<< HEAD
#ifndef CGSCENEGRAPH_H
#define CGSCENEGRAPH_H

#include <vector>
#include <glm/glm.hpp>
#include <string>
#include "../CgBase/CgBaseRenderableObject.h"
#include "CgAppearance.h"
#include "CgSceneGraph.h"
#include "CgBase/CgBaseRenderer.h"

class CgSceneGraph;

class CgSceneGraphEntity
{
public:
    CgSceneGraphEntity();
    CgSceneGraphEntity(CgBaseRenderableObject* objects);


    CgBaseRenderableObject* getObject();
    glm::mat4 getCurrentTransformation();
    CgAppearance& getAppearance();
    const CgSceneGraphEntity& getParent() const;
    const std::vector<CgSceneGraphEntity*> getChildren() const;
    glm::mat4 getObjectTransformation() const;

    void setObject(CgBaseRenderableObject* object);
    void setCurrentTransformation(glm::mat4 curren_transformation);
    void setAppearance(CgAppearance* appearance);
    void setParent(CgSceneGraphEntity* parent);
    void setObjectTransformation(const glm::mat4 &object_transformation);

    void pushChildren(CgSceneGraphEntity* child);
    void removeLastChild();
private:
    CgBaseRenderableObject* m_object;
    glm::mat4 m_current_transformation;
    glm::mat4 m_object_transformation;

    CgAppearance m_appearance;

    CgSceneGraphEntity* m_parent;
    std::vector<CgSceneGraphEntity*> m_children;
};
#endif // CGSCENEGRAPH_H
=======
#ifndef CGSCENEGRAPH_H
#define CGSCENEGRAPH_H

#include <vector>
#include <glm/glm.hpp>
#include <string>
#include "../CgBase/CgBaseRenderableObject.h"
#include "CgAppearance.h"
#include "CgSceneGraph.h"
#include "CgBase/CgBaseRenderer.h"

class CgSceneGraph;

class CgSceneGraphEntity
{
public:
    CgSceneGraphEntity();
    CgSceneGraphEntity(std::vector<CgBaseRenderableObject*> objects);


    const std::vector<CgBaseRenderableObject*>& getListOfObjects() const;
    void setListOfObjects(std::vector<CgBaseRenderableObject*> list_of_objects);
    glm::mat4 getCurrentTransformation();
    void setCurrentTransformation(glm::mat4 curren_transformation);

    CgAppearance& getAppearance();
    void setAppearance(CgAppearance* appearance);

    const CgSceneGraphEntity& getParent() const;
    void setParent(CgSceneGraphEntity* parent);

    const std::vector<CgSceneGraphEntity*> getChildren() const;
    void pushChildren(CgSceneGraphEntity* child);
    void removeLastChild();

    glm::mat4 getObjectTransformation() const;
    void setObjectTransformation(const glm::mat4 &object_transformation);

private:
    std::vector<CgBaseRenderableObject*> m_list_of_objects;
    glm::mat4 m_current_transformation;
    glm::mat4 m_object_transformation;

    CgAppearance m_appearance;

    CgSceneGraphEntity* m_parent;
    std::vector<CgSceneGraphEntity*> m_children;
};

#endif // CGSCENEGRAPH_H
>>>>>>> 2bba44709ff951a034d04fd1e87594f07d0ef76e
