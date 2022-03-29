#include "CgPolyline.h"
#include "CgBase/CgEnums.h"
#include "CgUtils/ObjLoader.h"

CgPolyline::CgPolyline():
m_type(Cg::Polyline),
m_id(42)
{

}

CgPolyline::CgPolyline(int id):
m_type(Cg::Polyline),
m_id(id)
{

}

CgPolyline::~CgPolyline(){

}

const std::vector<glm::vec3>& CgPolyline::getVertices() {

}
glm::vec3 CgPolyline::getColor() const {
    return m_face_colors;
}
unsigned int CgPolyline::getLineWidth() const {
    return m_line_width;
}
