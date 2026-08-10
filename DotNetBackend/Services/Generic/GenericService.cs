using AutoMapper;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Services.Generic
{
    public class GenericService<TEntity, TDto>
        : IGenericService<TDto>
        where TEntity : class
        where TDto : class
    {
        protected readonly IGenericRepository<TEntity> _repository;

        protected readonly IMapper _mapper;

        public GenericService(
            IGenericRepository<TEntity> repository,
            IMapper mapper)
        {
            _repository = repository;

            _mapper = mapper;
        }

        public virtual List<TDto> GetAll()
        {
            var data = _repository.GetAll();

            return _mapper.Map<List<TDto>>(data);
        }

        public virtual TDto? GetById(int id)
        {
            var entity = _repository.GetById(id);

            if (entity == null)
                throw new Exception("Record not found.");

            return _mapper.Map<TDto>(entity);
        }

        public virtual TDto Add(TDto dto)
        {
            var entity = _mapper.Map<TEntity>(dto);

            _repository.Add(entity);

            _repository.Save();

            return _mapper.Map<TDto>(entity);
        }

        public virtual TDto Update(int id, TDto dto)
        {
            var entity = _repository.GetById(id);

            if (entity == null)
                throw new Exception("Record not found.");

            _mapper.Map(dto, entity);

            _repository.Update(entity);

            _repository.Save();

            return _mapper.Map<TDto>(entity);
        }

        public virtual void Delete(int id)
        {
            var entity = _repository.GetById(id);

            if (entity == null)
                throw new Exception("Record not found.");

            _repository.Delete(entity);

            _repository.Save();
        }
    }
}