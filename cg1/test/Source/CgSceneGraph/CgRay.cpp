#include "CgRay.h"
#include "CgBase/CgEnums.h"
#include "CgUtils/ObjLoader.h"
#include <iostream>

CgRay::CgRay(int id, std::vector<glm::vec3> vertices):
scaler {10.0},
m_type(Cg::Polyline),
m_id(id),
m_line_width{1},
m_face_colors{Functions::getGreen()}
{
    for(unsigned int i = 0; i< vertices.size(); i++) {
        m_vertices.push_back(vertices.at(i));
    }
}

CgRay::~CgRay(){
    m_vertices.clear();
}

const std::vector<glm::vec3>& CgRay::getVertices() const
{
    return m_vertices;
}

glm::vec3 CgRay::getColor() const {
    return m_face_colors;
}

unsigned int CgRay::getLineWidth() const {
    return m_line_width;
}

void CgRay::setVertices(std::vector<glm::vec3> newvertices){
    m_vertices.clear();
    for(unsigned int i = 0; i< newvertices.size(); ++i) {
        m_vertices.push_back(newvertices.at(i));
    }
}

void CgRay::addVertice(glm::vec3 vertex) {
    m_vertices.push_back(vertex);
}

glm::vec4 CgRay::getPickingPoint() { return picking_point; }

void CgRay::setPickingPoint(glm::vec4 picking_point) {
    this->picking_point = picking_point;
    this->picking_point /= this->picking_point[3];
    createRay();
}

void CgRay::applyTransformation(glm::mat4 matrix) {
    picking_point = matrix * picking_point;
    this->picking_point /= this->picking_point[3];
    createRay();
}

glm::vec4 CgRay::getEndPoint() { return end_point; }

void CgRay::setEndPoint(glm::vec4 end_point) { this->end_point = end_point; }

void CgRay::createRay() {
    std::vector<glm::vec3> tmp_vertices;
    tmp_vertices.push_back(glm::vec3(picking_point[0], picking_point[1], picking_point[2]));
    tmp_vertices.push_back(glm::vec3(scaler * picking_point[0], scaler * picking_point[1], scaler * picking_point[2]));
    setVertices(tmp_vertices);
}


