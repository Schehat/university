#include "CgRay.h"
#include "CgBase/CgEnums.h"
#include "CgUtils/ObjLoader.h"
#include <iostream>

CgRay::CgRay(int id, std::vector<glm::vec3> vertices):
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
