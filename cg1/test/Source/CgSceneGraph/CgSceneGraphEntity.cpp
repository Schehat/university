#include "CgSceneGraphEntity.h"
#include "CgAppearance.h"

CgSceneGraphEntity::CgSceneGraphEntity()
{
    setCurrentTransformation(glm::mat4(1.));
    setObjectTransformation(glm::mat4(1.));
    m_aabb = new CgUnityCube(Functions::getId());
}
CgSceneGraphEntity::CgSceneGraphEntity(CgBaseTriangleMesh* object) : m_object(object) {
    setCurrentTransformation(glm::mat4(1.));
    setObjectTransformation(glm::mat4(1.));
}

CgBaseTriangleMesh* CgSceneGraphEntity::getObject() {
    return m_object;
}
void CgSceneGraphEntity::setObject(CgBaseTriangleMesh* object) {
    this->m_object = object;
}

glm::mat4 CgSceneGraphEntity::getCurrentTransformation() {
    return m_current_transformation;
}
void CgSceneGraphEntity::setCurrentTransformation(glm::mat4 curren_transformation) {
    m_current_transformation = curren_transformation;
}


CgAppearance& CgSceneGraphEntity::getAppearance() {
    return m_appearance;
}
void CgSceneGraphEntity::setAppearance(CgAppearance* appearance) {
    m_appearance = *appearance;
}


const CgSceneGraphEntity& CgSceneGraphEntity::getParent() const {
    return *m_parent;
}
void CgSceneGraphEntity::setParent(CgSceneGraphEntity* parent) {
    m_parent = parent;
}


const std::vector<CgSceneGraphEntity*> CgSceneGraphEntity::getChildren() const {
    return m_children;
}

void CgSceneGraphEntity::pushChildren(CgSceneGraphEntity* child) {
    m_children.push_back(child);
}

void CgSceneGraphEntity::removeLastChild() {
    m_children.pop_back();
}

glm::mat4 CgSceneGraphEntity::getObjectTransformation() const
{
    return m_object_transformation;
}

void CgSceneGraphEntity::setObjectTransformation(const glm::mat4 &object_transformation)
{
    m_object_transformation = object_transformation;
}

CgUnityCube* CgSceneGraphEntity::getAABB() {
    // TODO: get vertices empty fix?
//    std::cout << m_aabb->getVertices().size() << "\n";
//    for (int i = 0; i < m_aabb->getVertices().size(); ++i) {
//        std::cout << m_aabb->getVertices()[i][0] << " " <<
//                     m_aabb->getVertices()[i][1] << " " <<
//                     m_aabb->getVertices()[i][2] << "\n";
//    }
    return m_aabb;
}
void CgSceneGraphEntity::setAABB(CgUnityCube* aabb) { m_aabb = aabb; }
void CgSceneGraphEntity::setAABB(float x_min, float x_max, float y_min, float y_max, float z_min, float z_max) {
    //delete m_aabb;
    m_aabb = new CgUnityCube(Functions::getId(), x_min, x_max, y_min, y_max, z_min, z_max);
}
